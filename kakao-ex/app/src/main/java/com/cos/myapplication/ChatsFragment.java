package com.cos.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ChatsFragment extends Fragment {

    private ChatAdapter chatAdapter;
    private RecyclerView rvList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_chats, container, false);
        rvList = view.findViewById(R.id.rv_chats_list);

        List<Chat> chats = new ArrayList<>();

        for(int i =1; i < 30 ; i++){
            chats.add(new Chat(i, "user"+i, "massage"+i, i+"시간 전"));
        }
        LinearLayoutManager manager = new LinearLayoutManager(container.getContext(), RecyclerView.VERTICAL,false);
        rvList.setLayoutManager(manager);
        chatAdapter = new ChatAdapter(chats);
        rvList.setAdapter(chatAdapter);

        return view;

    }
}
