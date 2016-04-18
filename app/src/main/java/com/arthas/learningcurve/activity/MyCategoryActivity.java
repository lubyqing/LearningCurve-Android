package com.arthas.learningcurve.activity;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.arthas.learningcurve.R;
import com.arthas.learningcurve.adapter.holder.*;
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

        TreeNode
                myProfile =
                new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_person,
                                                                 "My Profile")).setViewHolder(
                        new ProfileHolder(this));
        TreeNode
                bruce =
                new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_person,
                                                                 "Bruce Wayne"))
                        .setViewHolder(new ProfileHolder(this));

        addProfileData(myProfile);
        addProfileData(bruce);
        root.addChildren(myProfile,bruce);
        AndroidTreeView tView = new AndroidTreeView(this, root);
        tView.setDefaultAnimation(true);
        tView.setDefaultContainerStyle(R.style.TreeNodeStyleDivided, true);
        mContainerView.addView(tView.getView());

        mHeaderBar.setOnHeaderBtnClickedListener(this);
    }

    @Override
    public void onHeaderRightClicked() {
        startActivity(AddNewCategoryActivity.class);
    }

    private void addProfileData(TreeNode profile) {
        TreeNode
                socialNetworks =
                new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_people,
                                                                 "Social")).setViewHolder(
                        new HeaderHolder(this));
        TreeNode
                places =
                new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_place,
                                                                 "Places")).setViewHolder(
                        new HeaderHolder(this));

        TreeNode
                facebook =
                new TreeNode(new SocialViewHolder.SocialItem(R.string.ic_post_facebook))
                        .setViewHolder(new SocialViewHolder(this));
        TreeNode
                linkedin =
                new TreeNode(new SocialViewHolder.SocialItem(R.string.ic_post_linkedin))
                        .setViewHolder(new SocialViewHolder(this));
        TreeNode
                google =
                new TreeNode(new SocialViewHolder.SocialItem(R.string.ic_post_gplus))
                        .setViewHolder(new SocialViewHolder(this));
        TreeNode
                twitter =
                new TreeNode(new SocialViewHolder.SocialItem(R.string.ic_post_twitter))
                        .setViewHolder(new SocialViewHolder(this));

        TreeNode
                lake =
                new TreeNode(new PlaceHolderHolder.PlaceItem("A rose garden")).setViewHolder(
                        new PlaceHolderHolder(this));
        TreeNode
                mountains =
                new TreeNode(new PlaceHolderHolder.PlaceItem("The white house"))
                        .setViewHolder(new PlaceHolderHolder(this));

        places.addChildren(lake, mountains);
        socialNetworks.addChildren(facebook, google, twitter, linkedin);
        profile.addChildren(socialNetworks, places);
    }
}
