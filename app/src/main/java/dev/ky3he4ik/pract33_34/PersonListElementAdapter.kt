package dev.ky3he4ik.pract33_34

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.ky3he4ik.pract33_34.databinding.PersonListElementBinding

class PersonListElementAdapter(private val data: List<Person>):
    RecyclerView.Adapter<PersonListElementAdapter.PersonListElementHolder>() {
    override fun getItemCount(): Int {
        return data.size
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PersonListElementHolder {
        val binding: PersonListElementBinding =
            PersonListElementBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return PersonListElementHolder(binding)
    }

    override fun onBindViewHolder(personListElementHolder: PersonListElementHolder, position: Int) {
        val person = data[position]
        personListElementHolder.binding.phone.text = person.phoneNumber
        personListElementHolder.binding.name.text = person.name
        personListElementHolder.binding.sex.setImageResource(
            when (person.sex.lowercaseChar()) {
                'm' -> R.drawable.male
                'f' -> R.drawable.female
                else -> R.drawable.ic_baseline_not_interested_24
            }
        )
    }
    class PersonListElementHolder(val binding: PersonListElementBinding) :
        RecyclerView.ViewHolder(binding.root)
}
