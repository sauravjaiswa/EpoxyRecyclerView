package com.saurav.epoxyrecyclerview

import android.view.View
import android.view.ViewParent
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.saurav.epoxyrecyclerview.model.Profile

@EpoxyModelClass(layout = R.layout.viewholder_recently_active_item)
abstract class RecentlyActiveItemModel: EpoxyModelWithHolder<RecentlyActiveItemModel.Holder>() {

    @EpoxyAttribute
    lateinit var profile: Profile

    override fun  bind(holder: Holder){
        super.bind(holder)
        with(profile){
            holder.profileName.text=name
            holder.lastSeen.text=lastSeen
        }
    }

    class Holder: EpoxyHolder(){
        lateinit var profileImage: ImageView
        lateinit var profileName: AppCompatTextView
        lateinit var lastSeen: AppCompatTextView

        override fun bindView(itemView: View) {
            profileImage=itemView.findViewById(R.id.recently_added_profile_image)
            profileName=itemView.findViewById(R.id.recently_added_profile_name)
            lastSeen=itemView.findViewById(R.id.recently_added_last_seen)
        }
    }
}