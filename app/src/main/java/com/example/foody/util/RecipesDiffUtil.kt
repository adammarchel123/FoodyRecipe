package com.example.foody.util

import androidx.recyclerview.widget.DiffUtil
import com.example.foody.models.Result

class RecipesDiffUtil(

        private val oldList: List<Result>,
        private val newList: List<Result>
): DiffUtil.Callback() {
// DiffUtil untuk RecyclerView agar lebih optimal dalam melakukan update data.
// DiffUtil utk melakukan pengecekan perbedaan data pada list.
    override fun getOldListSize(): Int {
    // getOldListSize()-> Mengembalikan ukuran list yang lama.
        return oldList.size
    }

    override fun getNewListSize(): Int {
    // getNewListSize()-> Mengembalikan ukuran list yang baru.
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
    // areItemsTheSame(int oldItemPosition, int newItemPosition)-> Dipanggil oleh DiffUtil untuk memutuskan apakah dua object memiliki sama Item.
        return oldList[oldItemPosition] === newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
    // areContentsTheSame(int oldItemPosition, int newItemPosition)-> Mengecek apakah dua item memiliki data yang sama.
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}