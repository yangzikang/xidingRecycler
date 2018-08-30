package e.yzk.play;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<Model> mModelList;
    private LayoutInflater mInflater;

    public Adapter(Context context, List list) {
        mInflater = LayoutInflater.from(context);
        mModelList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_l, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Model model = mModelList.get(position);
        holder.mTextView.setText(model.getContent());
        holder.mImageView.setImageResource(model.getRsId());
    }

    @Override
    public int getItemCount() {
        return mModelList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextView;
        private ImageView mImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.txt);
            mImageView = itemView.findViewById(R.id.img);
        }
    }
}
