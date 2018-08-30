package e.yzk.play;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

import java.util.List;

public class StickyItemDecoration extends RecyclerView.ItemDecoration {

    private List<Model> mList;
    //矩形高度
    private int mRectHeight;
    //文字TextSize
    private int mTextPaintSize;
    private Paint mTxtPaint;
    private Paint mRectPaint;
    //分割线画笔
    private Paint mDividerPaint;

    public StickyItemDecoration(Context context, List<Model> list) {

        mList = list;
        mRectHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30,
                context.getResources().getDisplayMetrics());

        mTextPaintSize = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 17,
                context.getResources().getDisplayMetrics());
        mTxtPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTxtPaint.setColor(Color.BLACK);
        mTxtPaint.setTextSize(mTextPaintSize);

        mRectPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mRectPaint.setStyle(Paint.Style.FILL);
        mRectPaint.setColor(Color.parseColor("#DDDDDD"));

        mDividerPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mDividerPaint.setStyle(Paint.Style.FILL);
        mDividerPaint.setColor(Color.WHITE);
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);

        int childCount = parent.getChildCount();
        int itemCount = state.getItemCount(); //总数

        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();


        String preGroupTitle;
        String groupTitle = "";

        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            int pos = parent.getChildLayoutPosition(child);
            preGroupTitle = groupTitle;
            groupTitle = mList.get(pos).getTitle();
            //如果当前分组名和之前分组名一样，忽略此次循环
            if (groupTitle.equals(preGroupTitle)) {
                continue;
            }

            Log.e("yangge",""+child.getTop());
            //文字的基线，保证显示完全
            int textBaseLine = Math.max(mRectHeight, child.getTop());

            //分组标题
            String title = mList.get(pos).getTitle();

            int viewBottom = child.getBottom();
            //加入限定 防止数组越界
            if (pos + 1 < itemCount) {
                String nextGroupTitle = mList.get(pos + 1).getTitle();
                //当分组不一样  并且改组要向上移动时候
                if (!nextGroupTitle.equals(groupTitle) && viewBottom < textBaseLine) {
                    //将上一个往上移动
                    textBaseLine = viewBottom;
                }
            }
            //绘制边框
            c.drawRect(left, textBaseLine - mRectHeight, right, textBaseLine, mRectPaint);
            c.drawText(title, left, textBaseLine - mRectHeight / 2, mTxtPaint);
        }

    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int pos = parent.getChildLayoutPosition(view);
        if (pos == 0 || !mList.get(pos).getTitle().equals(mList.get(pos - 1).getTitle())) {
            outRect.top = mRectHeight;
        }
    }
}