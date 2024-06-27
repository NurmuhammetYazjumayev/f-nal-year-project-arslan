package com.example.project1662.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project1662.adapter.ChatAdapter
import com.example.project1662.databinding.ActivityChatBinding
import com.example.project1662.model.ChatMessage

class ChatActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val sampleConversation = listOf(
            ChatMessage("Arslan", "Hello! How can I help you today?", true),
            ChatMessage("Client", "I'm looking for a 2-bedroom apartment.", false),
            ChatMessage("Arslan", "We have several options available. Do you have a preferred location?", true),
            ChatMessage("Client", "I'd like something in downtown.", false),
            ChatMessage("Arslan", "Great! We have a few properties that match your criteria. I can send you the details.", true),
            ChatMessage("Client", "That would be perfect. Thank you!", false)
        )

        val chatAdapter = ChatAdapter(sampleConversation)
        binding.chatRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.chatRecyclerView.adapter = chatAdapter
    }
}
