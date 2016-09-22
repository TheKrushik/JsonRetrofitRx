package info.krushik.android.jsonretrofitrx.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import info.krushik.android.jsonretrofitrx.R;
import info.krushik.android.jsonretrofitrx.api.Video;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {

    private List<Video> videoList;

    public VideoAdapter(List<Video> videoList) {
        this.videoList = videoList;
    }

    @Override
    public int getItemCount() {

        if (videoList != null) {
            return videoList.size();
        } else {
            return 0;
        }
    }

    @Override
    public VideoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.cardview_layout, viewGroup, false);

        return new VideoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(VideoViewHolder videoViewHolder, int position) {
        Video vi = videoList.get(position);
        videoViewHolder.title.setText(vi.getTitle());
        videoViewHolder.picture.setText(vi.getPicture());
        videoViewHolder.desc.setText(vi.getDesc());
        videoViewHolder.length.setText(vi.getLength());
        videoViewHolder.dt.setText(vi.getDt());
        videoViewHolder.video.setText(vi.getVideo());

    }

    public class VideoViewHolder extends RecyclerView.ViewHolder {

        protected TextView title;
        protected TextView picture;
        protected TextView desc;
        protected TextView length;
        protected TextView dt;
        protected TextView video;
        protected LinearLayout container;

        public VideoViewHolder(View v) {
            super(v);
            container = (LinearLayout) v.findViewById(R.id.item_layout_container);
            title = (TextView) v.findViewById(R.id.title);
            picture = (TextView) v.findViewById(R.id.picture);
            desc = (TextView) v.findViewById(R.id.desc);
            length = (TextView) v.findViewById(R.id.length);
            dt = (TextView) v.findViewById(R.id.dt);
            video = (TextView) v.findViewById(R.id.video);
        }
    }
}
