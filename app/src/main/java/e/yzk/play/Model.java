package e.yzk.play;

public class Model {

    private String mTitle;
    private String mContent;
    private int mRsId;

    public Model(String title, String content, int rsId) {
        mTitle = title;
        mContent = content;
        mRsId = rsId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String content) {
        mContent = content;
    }

    public int getRsId() {
        return mRsId;
    }

    public void setRsId(int rsId) {
        mRsId = rsId;
    }
}
