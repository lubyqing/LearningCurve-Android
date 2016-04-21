package com.arthas.learningcurve.adapter.holder;

import android.content.Context;
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
public class ThirdLevelHolder extends TreeNode.BaseNodeViewHolder<CategoryTreeModel> {

    public ThirdLevelHolder(Context context) {
        super(context);
    }

    @Override
    public View createNodeView(TreeNode node, CategoryTreeModel value) {
        final LayoutInflater inflater = LayoutInflater.from(context);
        final View
                view = inflater.inflate(R.layout.layout_third_level_node, null, false);

        final PrintView iconView = (PrintView) view.findViewById(R.id.pv_node_icon);
        iconView.setIconText(value.getIconFont());

        TextView textView = (TextView) view.findViewById(R.id.pv_node_text);
        textView.setText(value.getCategoryName());


        PrintView arrowView = (PrintView) view.findViewById(R.id.pv_node_arrow);
        if (node.isLeaf()) {
            arrowView.setVisibility(View.INVISIBLE);
        }

        return view;
    }


}
