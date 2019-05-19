package hse.t.alicemaster;

import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

import java.io.IOException;

import hse.t.alicemaster.databinding.ActivityHlsBinding;

public class HLSActivity extends AppCompatActivity implements MediaSourceEventListener, BandwidthMeter.EventListener {

    private static final String TAG = "HLSActivity";

    ActivityHlsBinding binding;

    LinearLayout exoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hls);

        String title = getIntent().getExtras().getString("title");
        String rating = getIntent().getExtras().getString("rating");
        String description = getIntent().getExtras().getString("description");
        String image_url = getIntent().getExtras().getString("image");
//        String adult = getIntent().getExtras().getString("adult");
//        String video_url = getIntent().getExtras().getString("video");
//        String price = getIntent().getExtras().getString("price");

        TextView new_title = findViewById(R.id.new_title);
        TextView new_rating = findViewById(R.id.new_rating);
        TextView new_description = findViewById(R.id.new_description);
        ImageView new_poster = findViewById(R.id.new_poster);
//        TextView new_adult = findViewById(R.id.adult);
//        TextView new_price = findViewById(R.id.price);

        new_title.setText(title);
        new_rating.setText(rating);
        new_description.setText(description);
//        new_adult.setText(adult);
//        new_price.setText(price);

        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);

        // set image using Glide
        Glide.with(this).load(image_url).apply(requestOptions).into(new_poster);

        String HLS_URL = "http://er-cdn.ertelecom.ru/os/video/hls/c60d67d76777defe36e187c0a0a60a323e9c9fa4d49091f77be1ebc1408042918592c7db77d8733dc8b3f5b35d475e5f73a4583e84b17e3c00a129113b7162254273fe0bc1f02200361a45fff5d91ac259eea6bad7db32bd8cabd9b8d902725d3d13d3519cf6a209e5ef84b78077bb991645af9cbb968223446bca4e0296596253605bad6c1095a20f34a9215efeba47d94c3afd9da2e411049c9abaee2aee52a3d00d91195de8f95e3a559483a27c37f94d0adc7c0aa8b36bdf054b63a5ac37b61008a92b592444162c216aaa8f0fd186516234f20c80eccdd361b7ecb33a02adac3206edeb4021c94e66c706ec1b93a9ab61089e4a00f2f95561527e26188ec3b8d8d141fe5226c6dba768fc03c80afc488c69f014786f4779e544bd686364e8a194edfa36ed8e318d2f1c572e280ff947646410f30ea8edfa4bb0d0680a465613cbe9a1ef0318cadb467acb4ab83edc67adb4b015c31a29bfbe6e15a003ec/playlist.m3u8";

        MediaSourceEventListener eventListener = this;
        BandwidthMeter.EventListener bandwidthMeterEventListener = this;

        Handler mainHandler = new Handler();
        DefaultBandwidthMeter bandwidthMeter = new DefaultBandwidthMeter.Builder()
                .setEventListener(mainHandler, bandwidthMeterEventListener)
                .build();

        TrackSelection.Factory videoTrackSelectionFactory = new AdaptiveTrackSelection.Factory(bandwidthMeter);
        TrackSelector trackSelector = new DefaultTrackSelector(videoTrackSelectionFactory);
        LoadControl loadControl = new DefaultLoadControl();
        SimpleExoPlayer player = ExoPlayerFactory.newSimpleInstance(this, trackSelector, loadControl);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_hls);
        binding.exoplayer.setPlayer(player);

        // Produces DataSource instances through which media data is loaded.
        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(this, Util.getUserAgent(this, "example-hls-app"), bandwidthMeter);

        // This is the MediaSource representing the media to be played.
        HlsMediaSource videoSource = new HlsMediaSource(Uri.parse(HLS_URL), dataSourceFactory, 5, mainHandler, eventListener);

        // Prepare the player with the source.
        player.prepare(videoSource);

        //не оплачено
//        if(video_url.replaceAll(" ", "") == ""){
////            exoView.setVisibility(View.INVISIBLE);
////            not_buy.setVisibility(View.VISIBLE);
////        } else {
////            String HLS_URL = video_url;
////            MediaSourceEventListener eventListener = this;
////            BandwidthMeter.EventListener bandwidthMeterEventListener = this;
////
////            Handler mainHandler = new Handler();
////            DefaultBandwidthMeter bandwidthMeter = new DefaultBandwidthMeter.Builder()
////                    .setEventListener(mainHandler, bandwidthMeterEventListener)
////                    .build();
////
////            TrackSelection.Factory videoTrackSelectionFactory = new AdaptiveTrackSelection.Factory(bandwidthMeter);
////            TrackSelector trackSelector = new DefaultTrackSelector(videoTrackSelectionFactory);
////            LoadControl loadControl = new DefaultLoadControl();
////            SimpleExoPlayer player = ExoPlayerFactory.newSimpleInstance(this, trackSelector, loadControl);
////
////            binding = DataBindingUtil.setContentView(this, R.layout.activity_hls);
////            binding.exoplayer.setPlayer(player);
////            binding.exoplayer.setVisibility(View.VISIBLE);
////
////            // Produces DataSource instances through which media data is loaded.
////            DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(this, Util.getUserAgent(this, "example-hls-app"), bandwidthMeter);
////
////            // This is the MediaSource representing the media to be played.
////            HlsMediaSource videoSource = new HlsMediaSource(Uri.parse(HLS_URL), dataSourceFactory, 5, mainHandler, eventListener);
////
////            // Prepare the player with the source.
////            player.prepare(videoSource);
////        }

    }

    @Override
    public void onMediaPeriodCreated(int windowIndex, MediaSource.MediaPeriodId mediaPeriodId) {

    }

    @Override
    public void onMediaPeriodReleased(int windowIndex, MediaSource.MediaPeriodId mediaPeriodId) {

    }

    @Override
    public void onLoadStarted(int windowIndex, @Nullable MediaSource.MediaPeriodId mediaPeriodId, MediaSourceEventListener.LoadEventInfo loadEventInfo, MediaSourceEventListener.MediaLoadData mediaLoadData) {

    }

    @Override
    public void onLoadCompleted(int windowIndex, @Nullable MediaSource.MediaPeriodId mediaPeriodId, MediaSourceEventListener.LoadEventInfo loadEventInfo, MediaSourceEventListener.MediaLoadData mediaLoadData) {

    }

    @Override
    public void onLoadCanceled(int windowIndex, @Nullable MediaSource.MediaPeriodId mediaPeriodId, MediaSourceEventListener.LoadEventInfo loadEventInfo, MediaSourceEventListener.MediaLoadData mediaLoadData) {

    }

    @Override
    public void onLoadError(int windowIndex, @Nullable MediaSource.MediaPeriodId mediaPeriodId, MediaSourceEventListener.LoadEventInfo loadEventInfo, MediaSourceEventListener.MediaLoadData mediaLoadData, IOException error, boolean wasCanceled) {

    }

    @Override
    public void onReadingStarted(int windowIndex, MediaSource.MediaPeriodId mediaPeriodId) {

    }

    @Override
    public void onUpstreamDiscarded(int windowIndex, MediaSource.MediaPeriodId mediaPeriodId, MediaSourceEventListener.MediaLoadData mediaLoadData) {

    }

    @Override
    public void onDownstreamFormatChanged(int windowIndex, @Nullable MediaSource.MediaPeriodId mediaPeriodId, MediaSourceEventListener.MediaLoadData mediaLoadData) {

    }

    @Override
    public void onBandwidthSample(int elapsedMs, long bytes, long bitrate) {
        //String.format("Bandwith sample elapsedMs=%dms, bytes=%d, bitrate=%d", elapsedMs, bytes, bitrate)
    }

}
