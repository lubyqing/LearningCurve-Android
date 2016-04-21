package com.arthas.learningcurve.adapter.holder;

import android.content.Context;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.arthas.learningcurve.R;
import com.arthas.learningcurve.model.CategoryTreeModel;
import com.github.johnkil.print.PrintView;
import com.unnamed.b.atv.model.TreeNode;

/**
 * Created by Bogdan Melnychuk on 2/13/15.
 */
public class SecondLevelHolder extends TreeNode.BaseNodeViewHolder<CategoryTreeModel> {

    private PrintView arrowView;

    public SecondLevelHolder(Context context) {
        super(context);
    }

    @Override
    public View createNodeView(TreeNode node, CategoryTreeModel value) {
        final LayoutInflater inflater = LayoutInflater.from(context);
        final View
                view = inflater.inflate(R.layout.layout_second_level_node, null, false);

        TextView tvValue = (TextView) view.findViewById(R.id.pv_node_text);
        SpannableString spannableString = new SpannableString(" (5)");
        ForegroundColorSpan span = new ForegroundColorSpan(context.getResources().getColor(R.color.common_green));
        spannableString.setSpan(span,0,spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        AbsoluteSizeSpan sizeSpan = new AbsoluteSizeSpan(30);
        spannableString.setSpan(sizeSpan,0,spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvValue.setText(value.getCategoryName());
        tvValue.append(spannableString);

        final PrintView iconView = (PrintView) view.findViewById(R.id.pv_node_icon);
        iconView.setIconText(value.getIconFont());

        arrowView = (PrintView) view.findViewById(R.id.pv_node_arrow);
        if (node.isLeaf()) {
            arrowView.setVisibility(View.INVISIBLE);
        }

        return view;
    }

    @Override
    public void toggle(boolean active) {
        arrowView.setIconText(context.getResources().getString(active ? R.string.ic_keyboard_arrow_down : R.string.ic_keyboard_arrow_right));
    }


}
