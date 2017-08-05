package apk.cn.zeffect.webviewvideo.ui.regextask;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import apk.cn.zeffect.webviewvideo.R;
import apk.cn.zeffect.webviewvideo.adapter.RegexAdapter;
import apk.cn.zeffect.webviewvideo.bean.Rule;

/**
 * 用于添加正则表达式规则的Fragment
 * Created by Administrator on 2017/8/5.
 */

public class RegexFragment extends Fragment implements View.OnClickListener {

    private View mView;
    private RecyclerView mRegexsView;
    private Context mContext;
    private ArrayList<Rule> mRules = new ArrayList<>();
    private RegexAdapter mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
        mRules.add(new Rule());
        mRules.add(new Rule());
        mRules.add(new Rule());
        mRules.add(new Rule());
        mAdapter = new RegexAdapter(mContext, mRules);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(R.layout.fragment_regex, container, false);
            initView();
        }
        return mView;
    }

    private void initView() {
        mView.findViewById(R.id.title_back).setOnClickListener(this);
        ((TextView) mView.findViewById(R.id.title_text)).setText("匹配规则");
        mRegexsView = (RecyclerView) mView.findViewById(R.id.regex_rcv);
        //
        mRegexsView.setLayoutManager(new LinearLayoutManager(mContext));
        mRegexsView.setAdapter(mAdapter);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.title_back) {
            getActivity().finish();
        }
    }
}
