package onlineshop.com;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemsViewHolder> {
    private List<ItemsModel> itemsModelList;
    private Context context;

    public ItemsAdapter(List<ItemsModel> list, Context context) {
        this.itemsModelList = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_itemsactivity, viewGroup, false);
        return new ItemsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemsViewHolder itemsViewHolder, final int i) {
        final ItemsModel itemsModel = itemsModelList.get(i);

        itemsViewHolder.itemImageName.setImageResource(itemsModel.getItemImageName());
        itemsViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, ItemDisplay.class);

                intent.putExtra("name", itemsModel.getItemName());
                intent.putExtra("desc", itemsModel.getItemDescription());
                intent.putExtra("image", itemsModel.getItemImageName());
                intent.putExtra("price", itemsModel.getItemPrice());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemsModelList.size();
    }


    public class ItemsViewHolder extends RecyclerView.ViewHolder {

        ImageView itemImageName;

        public ItemsViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImageName = itemView.findViewById(R.id.itemImage);

        }
    }
}
