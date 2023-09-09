package redouane.elaouni.iibdcc.listscontactsiibdcc;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    // Initialize variable
    private List<ItemModel> dataList;
    private Activity context;


    //Create constructor
    public MainAdapter(Activity context, List<ItemModel> dataList) {
        this.context = context;
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    {

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Initialize view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        // Initialize main data
        final ItemModel data = dataList.get(position);

        // Set text on text view
        holder.name.setText(data.getName());
        holder.email.setText(data.getEmail());
        holder.job.setText(data.getJob());
        holder.phone.setText(data.getPhone());


        holder.btnCall.setOnClickListener(view1 -> {
            Uri telephone = Uri.parse("tel:" + data.getPhone());
            Intent secondeActivite = new Intent(Intent.ACTION_DIAL, telephone);
            context.startActivity(secondeActivite);
        });



    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageButton btnCall;
        //Initialize variable
        TextView name,job,email,phone;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // Assign variable

            name=itemView.findViewById(R.id.txt_name);
            job=itemView.findViewById(R.id.txt_job);
            email=itemView.findViewById(R.id.txt_email);
            phone=itemView.findViewById(R.id.txt_phone);
            btnCall = itemView.findViewById(R.id.btn_call);
        }
    }
}
