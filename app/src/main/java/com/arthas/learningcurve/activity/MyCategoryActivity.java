package com.arthas.learningcurve.activity;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.arthas.learningcurve.R;
import com.arthas.learningcurve.widget.HeaderBar;
import com.unnamed.b.atv.model.TreeNode;
import com.unnamed.b.atv.view.AndroidTreeView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Tcz on 16/4/18.
 */
public class MyCategoryActivity extends BaseActivity {
    @Bind(R.id.header_bar)
    HeaderBar mHeaderBar;
    @Bind(R.id.container)
    FrameLayout mContainerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_category);
        ButterKnife.bind(this);

        TreeNode root = TreeNode.root();
        TreeNode parent = new TreeNode("MyParentNode");
        TreeNode child0 = new TreeNode("ChildNode0");
        TreeNode child1 = new TreeNode("ChildNode1");
        parent.addChildren(child0, child1);
        root.addChild(parent);
        AndroidTreeView tView = new AndroidTreeView(this, root);
        mContainerView.addView(tView.getView());
    }
}
