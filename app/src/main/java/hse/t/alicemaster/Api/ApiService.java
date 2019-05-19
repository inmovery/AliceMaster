package hse.t.alicemaster.Api;

import hse.t.alicemaster.Model.DataFilms;
import hse.t.alicemaster.Model.Url.DataUrl;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    /*
    * Запрос по поиску фильмов
    * */
    @Headers({
            "View: stb3",
            "X-Auth-Token: eyJkYXRhIjoie1wiZXhwaXJlc1wiOjE1NjA1OTM4MjUsXCJsaWZlc3BhblwiOjI1OTIwMDAsXCJwcmluY2lwYWxcIjp7XCJmcmVlbWl1bVwiOjAsXCJleHRpZFwiOlwibWFjOkY4OkYwOjgyOjQwOjg3OjkxXCIsXCJzdWJzY3JpYmVyXCI6e1wiaXNfZ3Vlc3RcIjpmYWxzZSxcInR5cGVcIjpcInN1YnNjcmliZXJcIixcImlkXCI6NzkyNTMzODMsXCJncm91cHNcIjpbe1wiaWRcIjozNTAzNCxcImV4dGlkXCI6XCJlcjpkb21haW46a3Jza1wifV0sXCJleHRpZFwiOlwia3JzazoyNDAwMDk0MzYwMzVcIn0sXCJwbGF0Zm9ybVwiOntcIm9wZXJhdG9yXCI6e1widGl0bGVcIjpcIlwiLFwiaWRcIjoyLFwiZXh0aWRcIjpcImVyXCJ9LFwidGl0bGVcIjpcIlwiLFwiaWRcIjo0NCxcImV4dGlkXCI6XCJhbmRyb2lkX2lwdHZcIn0sXCJhdHRyc1wiOm51bGwsXCJncm91cHNcIjpbe1wiaWRcIjozNDE5NyxcImV4dGlkXCI6XCJlcjpldmVyeW9uZVwifV0sXCJvcGVyYXRvclwiOntcInRpdGxlXCI6XCJcIixcImlkXCI6MixcImV4dGlkXCI6XCJlclwifSxcInR5cGVcIjpcImRldmljZVwiLFwiaWRcIjo1ODA0MDI4NH19Iiwic2lnbmF0dXJlIjoiRFVcL0RITU5xNmhPUjM3NWQ0TXFcL2pMdzJuZ3JQTWhVR0VcL3Ewa21scE54Yz0ifQ=="
    })
    @GET("https://discovery-stb3.ertelecom.ru/api/v3/pages/search")
    Call<DataFilms> getDataFilms(
            @Query("text") String text,
            @Query("limit") int limit
    );

    /*
     * Запрос на получение данных о картинке и ссылке на видео
     * */
    @Headers({
            "View: stb3",
            "X-Auth-Token: eyJkYXRhIjoie1wiZXhwaXJlc1wiOjE1NjA2OTQ2MzIsXCJsaWZlc3BhblwiOjI1OTIwMDAsXCJwcmluY2lwYWxcIjp7XCJmcmVlbWl1bVwiOjAsXCJleHRpZFwiOlwibWFjOkE4OkY5OjRCOjJCOjhGOkNGXCIsXCJzdWJzY3JpYmVyXCI6e1wiaXNfZ3Vlc3RcIjpmYWxzZSxcInR5cGVcIjpcInN1YnNjcmliZXJcIixcImlkXCI6MzQ3MjksXCJncm91cHNcIjpbe1wiaWRcIjozNTAzNyxcImV4dGlkXCI6XCJlcjpkb21haW46cGVybVwifV0sXCJleHRpZFwiOlwicGVybTo1OTAwMTQ4MDkzOTRcIn0sXCJwbGF0Zm9ybVwiOntcIm9wZXJhdG9yXCI6e1widGl0bGVcIjpcIlwiLFwiaWRcIjoyLFwiZXh0aWRcIjpcImVyXCJ9LFwidGl0bGVcIjpcIlwiLFwiaWRcIjo0NCxcImV4dGlkXCI6XCJhbmRyb2lkX2lwdHZcIn0sXCJhdHRyc1wiOm51bGwsXCJncm91cHNcIjpbe1wiaWRcIjozNDE5NyxcImV4dGlkXCI6XCJlcjpldmVyeW9uZVwifV0sXCJvcGVyYXRvclwiOntcInRpdGxlXCI6XCJcIixcImlkXCI6MixcImV4dGlkXCI6XCJlclwifSxcInR5cGVcIjpcImRldmljZVwiLFwiaWRcIjozNDAzNDQyM319Iiwic2lnbmF0dXJlIjoiTHlpVkdER21lVEU2TFVIQkhEbVpwaXg3XC9SYWJLcDFYRDBIdDRSTXVSR0k9In0="
    })
    @GET("https://discovery-stb3.ertelecom.ru/resource/get_url/{id_asset}/{id_resource}")
    Call<DataUrl> getDataUrl(
            @Path("id_asset") String id_asset,
            @Query("id_resource") String id_resource
    );

    /* Получение списка преподавателей */
//    @GET("/tparser/teach.php")
//    Call<TeacherList> getTeachJSON();

    /* Получение расписания по сформированному запросу */
//    @GET("/tparser/teachers.php")
//    Call<LessonList> getLessonsJSON(
//            @Query("day") String day,
//            @Query("teach") String id,
//            @Query("type") String type,
//            @Query("update") String update
//    );
//
//    @GET("/tparser/push/checktoken.php")
//    Call<TokenStatus> getStatusToken(
//            @Query("id") String id
//    );



}
