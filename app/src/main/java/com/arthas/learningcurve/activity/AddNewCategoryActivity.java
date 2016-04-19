package com.arthas.learningcurve.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.arthas.learningcurve.R;
import com.cunoraz.tagview.Tag;
import com.cunoraz.tagview.TagView;
import me.next.tagview.TagCloudView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tcz on 16/4/18.
 */
public class AddNewCategoryActivity extends BaseActivity implements TagCloudView.OnTagClickListener {
    @Bind(R.id.view_tag_cloud)
    TagCloudView mTagCloudView;

    @Bind(R.id.view_tag)
    TagView mTagView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_category);
        ButterKnife.bind(this);

        initData();
    }

    private void initData() {
        List<String> tags = new ArrayList<>();
        List<Tag> tagList = new ArrayList<>();
        Tag tag = null;
        for (int i = 0; i < 20; i++) {
            tags.add("标签sss" + i);
            tag = new Tag("Englist"+i);
            tag.isDeletable = true;
            tagList.add(tag);
        }

        mTagView.addTags(tagList);

        mTagCloudView.setTags(tags);
        mTagCloudView.setOnTagClickListener(this);
        mTagCloudView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "TagView onClick",
                               Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onTagClick(int position) {
        if (position == -1) {
            Toast.makeText(getApplicationContext(), "点击末尾文字",
                           Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(), "点击 position : " + position,
                           Toast.LENGTH_SHORT).show();
        }
    }
}
