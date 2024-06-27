package com.example.project1662.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.project1662.R
import com.example.project1662.databinding.ItemChatBinding
import com.example.project1662.model.ChatMessage

class ChatAdapter(private val chatMessages: List<ChatMessage>) :
    RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val binding = ItemChatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChatViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        holder.bind(chatMessages[position])
    }

    override fun getItemCount(): Int {
        return chatMessages.size
    }

    class ChatViewHolder(private val binding: ItemChatBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(chatMessage: ChatMessage) {
            binding.senderTextView.text = chatMessage.sender
            binding.messageTextView.text = chatMessage.message

            if (chatMessage.isSentByMe) {
                binding.senderTextView.visibility = View.GONE
                binding.messageContainer.background = binding.root.context.getDrawable(R.drawable.message_background)
                binding.messageContainer.gravity = View.TEXT_ALIGNMENT_VIEW_END
            } else {
                binding.senderTextView.visibility = View.VISIBLE
                binding.messageContainer.background = binding.root.context.getDrawable(R.drawable.message_background_received)
                binding.messageContainer.gravity = View.TEXT_ALIGNMENT_VIEW_START
            }
        }
    }
}
