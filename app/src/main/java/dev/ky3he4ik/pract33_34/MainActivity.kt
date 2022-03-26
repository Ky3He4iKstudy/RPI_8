package dev.ky3he4ik.pract33_34

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import dev.ky3he4ik.pract33_34.databinding.ActivityMainBinding
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val items = Json.decodeFromString<MutableList<Person>>(readFromAsset())
        binding.recycler.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = PersonListElementAdapter(items)
        }
        binding.sortSex.setOnClickListener {
            items.sortWith { p1, p2 -> p1.sex.compareTo(p2.sex) }
            binding.recycler.adapter?.notifyItemRangeChanged(0, items.size)
        }
        binding.sortName.setOnClickListener {
            items.sortWith { p1, p2 -> p1.name.compareTo(p2.name) }
            binding.recycler.adapter?.notifyItemRangeChanged(0, items.size)
        }
        binding.sortPhone.setOnClickListener {
            items.sortWith { p1, p2 -> p1.phoneNumber.compareTo(p2.phoneNumber) }
            binding.recycler.adapter?.notifyItemRangeChanged(0, items.size)
        }
    }

    private fun readFromAsset(): String {
        return application.assets.open("persons.json").bufferedReader().use { it.readText() }
    }
}
