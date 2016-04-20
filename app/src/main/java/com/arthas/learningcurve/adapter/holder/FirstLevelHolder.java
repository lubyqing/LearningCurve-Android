package com.arthas.learningcurve.adapter.holder;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.arthas.learningcurve.R;
import com.arthas.learningcurve.model.CategoryModel;
import com.github.johnkil.print.PrintView;
import com.unnamed.b.atv.model.TreeNode;

/**
 * Created by Bogdan Melnychuk on 2/13/15.
 */
public class FirstLevelHolder extends TreeNode.BaseNodeViewHolder<CategoryModel> {


    public FirstLevelHolder(Context context) {
        super(context);
    }

    @Override
    public View createNodeView(TreeNode node, CategoryModel value) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.layout_first_level_node, null, false);
        TextView tvValue = (TextView) view.findViewById(R.id.pv_node_text);

        SpannableString spannableString = new SpannableString(" (20)");
        ForegroundColorSpan span = new ForegroundColorSpan(context.getResources().getColor(R.color.common_blue));
        spannableString.setSpan(span, 0, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        AbsoluteSizeSpan sizeSpan = new AbsoluteSizeSpan(30);
        spannableString.setSpan(sizeSpan, 0, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvValue.setText(value.getCategoryName());
        tvValue.append(spannableString);

        PrintView iconView = (PrintView) view.findViewById(R.id.pv_node_icon);
        iconView.setIconText(value.getIcon());
        iconView.setIconColor(value.getIconColor());

        PrintView addView = (PrintView) view.findViewById(R.id.pv_node_add);

        PrintView deleteView = (PrintView) view.findViewById(R.id.pv_node_delete);

        addView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CategoryModel model = new CategoryModel();
                model.setCategoryName("Two level");
                model.setIcon(value.getIcon());
                model.setIconColor(value.getIconColor());
                tView.addNode(node,new TreeNode(model).setViewHolder(new SecondLevelHolder(context)));
            }
        });

        return view;
    }
}
