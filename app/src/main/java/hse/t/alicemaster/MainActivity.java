package hse.t.alicemaster;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import hse.t.alicemaster.Adapters.Films;
import hse.t.alicemaster.Adapters.FilmsAdapter;
import hse.t.alicemaster.Api.ApiService;
import hse.t.alicemaster.Api.RetroClient;
import hse.t.alicemaster.Model.Data;
import hse.t.alicemaster.Model.DataFilms;
import hse.t.alicemaster.Model.Item;
import hse.t.alicemaster.Model.Resource;
import hse.t.alicemaster.Model.Showcase;
import hse.t.alicemaster.Model.Url.DataUrl;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.yandex.speechkit.Emotion;
import ru.yandex.speechkit.Error;
import ru.yandex.speechkit.Language;
import ru.yandex.speechkit.OnlineModel;
import ru.yandex.speechkit.OnlineVocalizer;
import ru.yandex.speechkit.SpeechKit;
import ru.yandex.speechkit.Synthesis;
import ru.yandex.speechkit.Vocalizer;
import ru.yandex.speechkit.VocalizerListener;
import ru.yandex.speechkit.Voice;
import ru.yandex.speechkit.gui.RecognizerActivity;

public class MainActivity extends AppCompatActivity implements VocalizerListener {

    private static final Set<Character> PUNCT_SET = new HashSet<>(Arrays.asList(
            '!', '"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-',
            '.', '/', ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^',
            '_', '`', '{', '|', '}', '~'
    ));

    private List<Showcase> datafilmsList;
    private String video_url = "";
    private static final String API_KEY_FOR_TESTS_ONLY = "069b6659-984b-4c5f-880e-aaedcfd84102";
    private static final int REQUEST_CODE = 31;

    private TextView resultView;
    private Button mSearch;
    private RelativeLayout mMainFrame;
    //private Button mTest;

    private List<Films> mData;
    private RecyclerView recyclerView;

    private Vocalizer vocalizer;

    private RequestQueue requestQueue;

    ApiService api = RetroClient.getApiService();//создание объекта интерфейса

    //069b6659-984b-4c5f-880e-aaedcfd84102 } тестовый
    //a85b2ad2-d525-4661-99c1-52308665276f } рабочий
    //private static final String API_KEY_FOR_TESTS_ONLY = "CggaATEVAgAAABKABEIHXYURroKx9lt-TOL-rQBJNwRcgRFXXLzUyzz92Ki87M-K6JBaSE69D9j0xxBg09HmlLbvEforj8MNavjzEHeMkR-WmnNCF0-nMNYErGrGTXJaPkCG8JpEr9QuoEkMqMDkM4NAWLskLQlLPR-Y5SHHcGtLylmC3l9ig78d9v7UI_HpdfzybciofKgMyqwSCk6BVqsOLaVl0JCjj2bDivPcigg9DK8VSzEiL2RRchyt_rWyUPtHkUqq8RiFFYjTOm-H3UVef_PEep8WbzsXAxSq8QpBgYDM3cjCt0BWxFSLrCtjIa-phKptyh0bh7Y5QvAoX6tFExJCNRHAFYIbDpu5_Q3KuFK52FduzqRRotXZsz2cJyz042JeEBFkpQVn_-rNplp8J1_xOyC7Q24-TGtCOj93oPLeXyB6npDqFNqtNFj5xRs2m8dFyjIKGz6BOJwxjDK0utc_TH1lCAOR4py234MxkZgUNhObjiRoVo90BxyXUe9am2JvzoqI0jJCoRH10btWnoJLnPEa_-TxtErDbdrPOXa4CYxtX2OfEifm0PcBoz1NUAEEJ25W1AjhpBjtL0q7C-w-hJCiWs8m7ESsuhjoKw7Eu4TCTy6IJmS6B_AcvGARyLKqXkaReowmfws51vCaFPEEeKgNHE6RsvEEgwkY8wiSn9esVBRu8BNqGmYKIDM3ZTFjYTFmMmRlMDQ3ZjQ4MGYxYTZiZDM3Yzk3YmEwEPWw_OYFGLWC_-YFIiQKFGFqZXEydnJqYjhmNXY2bnNoMzdsEgxwaXNrdW5vdi5yLmFaADACOAFKCBoBMRUCAAAAUAEg9QQ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            SpeechKit.getInstance().init(this, API_KEY_FOR_TESTS_ONLY);
            SpeechKit.getInstance().setUuid(UUID.randomUUID().toString());
        } catch (SpeechKit.LibraryInitializationException ignored) {}

        mData = new ArrayList<>();

        mSearch = findViewById(R.id.search_btn);
        resultView = findViewById(R.id.area_result);
        mMainFrame = findViewById(R.id.main_frame);
        //mTest = findViewById(R.id.test);
        recyclerView = findViewById(R.id.recycler_view);

        mSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateTextResult("");
                Intent intent = new Intent(MainActivity.this, RecognizerActivity.class);
                intent.putExtra(RecognizerActivity.EXTRA_MODEL, OnlineModel.QUERIES.getName());
                intent.putExtra(RecognizerActivity.EXTRA_LANGUAGE, Language.RUSSIAN.getValue());
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

//        mTest.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, HLSActivity.class);
//                startActivity(intent);
//            }
//        });

        vocalizer = new OnlineVocalizer.Builder(Language.RUSSIAN, MainActivity.this)
                .setVoice(Voice.ALYSS)
                .setAutoPlay(true)
                .setEmotion(Emotion.GOOD)
                .setSpeed(1.75f)
                .build();

    }

    public static String removePunct(String str) {
        StringBuilder result = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!PUNCT_SET.contains(Character.valueOf(c))) {
                result.append(c);
            }
        }
        return result.toString();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, requestCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RecognizerActivity.RESULT_OK && data != null) {
                final String result = data.getStringExtra(RecognizerActivity.EXTRA_RESULT);
                updateTextResult(result);
                getAnswer(removePunct(result));
//                if(result.toLowerCase().contains("запустить") || result.toLowerCase().contains("воспроизвести")){
//                    int search = 0;
//                    for(int i = 0; i < datafilmsList.size();i++){
//                        String temp = result.toLowerCase().contains("запустить");
//                        String ne_temp = temp.contains("воспроизвести");
//                        if(removePunct(datafilmsList.get(i).getItems().get(i).getTitle()) == result.toLowerCase().contains("запустить")){
//
//                        }
//                    }
//                    Intent i = new Intent(this, HLSActivity.class);
//                    i.putExtra("title", datafilmsList.get(search).getTitle());
//                    i.putExtra("rating", datafilmsList.get(search).getItems().get(i));
//                    i.putExtra("description", datafilmsList.get(search).getDescription());
//                    i.putExtra("image", datafilmsList.get(search).getImage_url());
////                    i.putExtra("adult", datafilmsList.get(viewHolder.getAdapterPosition()).getAdult());
////                    i.putExtra("video", datafilmsList.get(viewHolder.getAdapterPosition()).getVideo_url());
////                    i.putExtra("price", datafilmsList.get(viewHolder.getAdapterPosition()).getAdult());
//
//                    this.startActivity(i);
//                }
                
            } else if (resultCode == RecognizerActivity.RESULT_ERROR) {
                String error = data.getSerializableExtra(RecognizerActivity.EXTRA_ERROR).toString();
                updateTextResult(error);
            }
        }
    }

    /*
    * Обновление строки состояния поиска фильма
    * */
    private void updateTextResult(String message) {
        resultView.setText(removePunct(message));
    }

    /*
     * Поиск нужного ID_Image
     * */
    private int FindImageByType(List<Resource> list){
        List<Integer> posters = new ArrayList<Integer>();
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getType().contains("smarttv") || list.get(i).getType().contains("blueprint")){
                posters.add(list.get(i).getId());
            }
        }

        return posters.get(0);
    }

    /*
    * Поиск нужного ID_Resource
    * */
    private int FindIdResourceByType(List<Resource> list){
        int[] resource = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getType().contains("hls") || list.get(i).getDrm() == "verimatrix") {
                return list.get(i).getId();
            } else {
                continue;
            }
        }
        return 0;
    }

    private int FindPosterBytType(List<Resource> list){
        int[] resource = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getType().contains("poster")) {
                return list.get(i).getId();
            } else {
                continue;
            }
        }
        return 0;
    }


    private void getAnswer(final String title){

//        try {
//            Document doc  = Jsoup.connect("https://www.kinopoisk.ru/index.php?kp_query=" + title + "&what=").get();
//            Elements newsHeadlines = doc.select(".element most_wanted .info .name a");
//            for (Element headline : newsHeadlines) {
//                Log.d("PARSER", headline.attr("href"));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        /*Обращение к JSON*/
        Call<DataFilms> callDataFilms = api.getDataFilms(title,10);
        //Запрос
        callDataFilms.enqueue(new Callback<DataFilms>() {
            //успешно
            @Override
            public void onResponse(Call<DataFilms> call, Response<DataFilms> response) {
                if(response.isSuccessful()){
                    //получение списка учителей в качестве объектов Teacher
                    datafilmsList = response.body().getData().getShowcases();

                    try {
                        Showcase pre = datafilmsList.get(0);

                        for (int i = 0; i < pre.getItems().size(); i++) {

                            List<Resource> ex = pre.getItems().get(i).getResources();//список ресурсов для воспроизведения
                            int id_asset = pre.getItems().get(i).getId();
                            int id_resource = FindIdResourceByType(ex);// ID ресурса для получения URL на поток
                            int id_image = FindImageByType(ex);// ID постера в соответствующем URL
                            int id_poster_image = FindPosterBytType(ex);
                            String adult = pre.getItems().get(i).getOffer().getAdult().getType();
                            int price = pre.getItems().get(i).getOffer().getPrice();
                            String status = pre.getItems().get(i).getOffer().getStatus().getType();
                            String url = getVideoUrl(String.valueOf(id_asset), String.valueOf(id_resource));

                            Films film = new Films();

                            film.setTitle(pre.getItems().get(i).getTitle());
                            film.setRating(pre.getItems().get(i).getRating().getType());
                            film.setDescription(pre.getItems().get(i).getDescription().substring(0, 80));
                            film.setImage_url("http://er-cdn.ertelecom.ru/content/public/r" + String.valueOf(id_poster_image));
//                            film.setAdult(adult);
//                            film.setPrice(price);
//                            film.setVideo_url(url);
//                            film.setStatus(status);

                            mData.add(film);

                            mSearch.setVisibility(View.INVISIBLE);
                            Log.d("Response",
                                    "\n\nНазание: " + pre.getItems().get(i).getTitle() +
                                            "\nID Asset: " + String.valueOf(id_asset) +
                                            "\nID Resource:" + String.valueOf(id_resource) +
                                            "\nID Image: " + String.valueOf(id_image) +
                                            "\nURL VIDEO: " + String.valueOf(video_url) +
                                            "\nADULT: " + String.valueOf(adult) +
                                            "\nPRICE: " + String.valueOf(price) +
                                            "\nSTATUS: " + String.valueOf(status));
                            //Toast.makeText(getApplicationContext(), "ID Asset: "+String.valueOf(id_asset)+"\nID Resource:"+String.valueOf(id_resource)+"\nID Image: "+String.valueOf(id_image), Toast.LENGTH_SHORT).show();
                            vocalizer.synthesize("Подборка по запросу: "+title, Vocalizer.TextSynthesizingMode.INTERRUPT);
                        }
                    } catch(Exception e) {
                        vocalizer = new OnlineVocalizer.Builder(Language.RUSSIAN, MainActivity.this)
                                .setVoice(Voice.ALYSS)
                                .setAutoPlay(true)
                                .setEmotion(Emotion.EVIL)
                                .setSpeed(1.75f)
                                .build();
                        vocalizer.synthesize("К сожеланию, ничего не нашлось! ", Vocalizer.TextSynthesizingMode.INTERRUPT);
                        Toast.makeText(getApplicationContext(), "К сожеланию, ничего не нашлось!", Toast.LENGTH_SHORT).show();
                    }

                    SetupRecyclerView(mData);

                } else {
                    //сообщение об ошибке получение JSON
                    Toast.makeText(getApplicationContext(), "Ошибка в получении JSON", Toast.LENGTH_SHORT).show();
                }
            }

            //не успешно
            @Override
            public void onFailure(Call<DataFilms> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Нет интернета!", Toast.LENGTH_SHORT).show();

                Snackbar snackbar = Snackbar.make(mMainFrame, "Нет инетрнет соединения!", Snackbar.LENGTH_INDEFINITE)
                        .setAction("ОБНОВИТЬ", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                            }
                        });

                // Message text color
                snackbar.setActionTextColor(Color.rgb(124, 12, 176));

                View snackBarView = snackbar.getView();

                TextView textView = (TextView) snackBarView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.WHITE);
                snackbar.show();

                Toast.makeText(getApplicationContext(), "Не успешно", Toast.LENGTH_SHORT).show();
            }
        });

    }

    /*
    * Запрос URL фильма, если это возможно
    * */
    private String getVideoUrl(String id_asset, String id_resource){
        final String[] result = {""};
        String url = "https://discovery-stb3.ertelecom.ru/resource/get_url/"+id_asset+"/"+id_resource;

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url, null,
                new com.android.volley.Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            result[0] = response.getString("url");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        Log.d("ROLL", result[0]);
                    }
                }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                result[0] = "";
            }
        }) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("View", "stb3");
                headers.put("X-Auth-Token", "eyJkYXRhIjoie1wiZXhwaXJlc1wiOjE1NjA2OTQ2MzIsXCJsaWZlc3BhblwiOjI1OTIwMDAsXCJwcmluY2lwYWxcIjp7XCJmcmVlbWl1bVwiOjAsXCJleHRpZFwiOlwibWFjOkE4OkY5OjRCOjJCOjhGOkNGXCIsXCJzdWJzY3JpYmVyXCI6e1wiaXNfZ3Vlc3RcIjpmYWxzZSxcInR5cGVcIjpcInN1YnNjcmliZXJcIixcImlkXCI6MzQ3MjksXCJncm91cHNcIjpbe1wiaWRcIjozNTAzNyxcImV4dGlkXCI6XCJlcjpkb21haW46cGVybVwifV0sXCJleHRpZFwiOlwicGVybTo1OTAwMTQ4MDkzOTRcIn0sXCJwbGF0Zm9ybVwiOntcIm9wZXJhdG9yXCI6e1widGl0bGVcIjpcIlwiLFwiaWRcIjoyLFwiZXh0aWRcIjpcImVyXCJ9LFwidGl0bGVcIjpcIlwiLFwiaWRcIjo0NCxcImV4dGlkXCI6XCJhbmRyb2lkX2lwdHZcIn0sXCJhdHRyc1wiOm51bGwsXCJncm91cHNcIjpbe1wiaWRcIjozNDE5NyxcImV4dGlkXCI6XCJlcjpldmVyeW9uZVwifV0sXCJvcGVyYXRvclwiOntcInRpdGxlXCI6XCJcIixcImlkXCI6MixcImV4dGlkXCI6XCJlclwifSxcInR5cGVcIjpcImRldmljZVwiLFwiaWRcIjozNDAzNDQyM319Iiwic2lnbmF0dXJlIjoiTHlpVkdER21lVEU2TFVIQkhEbVpwaXg3XC9SYWJLcDFYRDBIdDRSTXVSR0k9In0=");
                return headers;
            }

        };

        requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(jsonObjReq);

        return result[0];

    }

    private void SetupRecyclerView(List<Films> films){
        FilmsAdapter adapter = new FilmsAdapter(this, mData);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onSynthesisDone(@NonNull Vocalizer vocalizer) {

    }

    @Override
    public void onPartialSynthesis(@NonNull Vocalizer vocalizer, @NonNull Synthesis synthesis) {

    }

    @Override
    public void onPlayingBegin(@NonNull Vocalizer vocalizer) {

    }

    @Override
    public void onPlayingDone(@NonNull Vocalizer vocalizer) {

    }

    @Override
    public void onVocalizerError(@NonNull Vocalizer vocalizer, @NonNull Error error) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        vocalizer.cancel();
        vocalizer.destroy();
        vocalizer = null;
    }

}
