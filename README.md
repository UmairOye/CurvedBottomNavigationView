## Demo
[![Demo CountPages alpha]https://github.com/UmairOye/CurvedBottomNavigationView/blob/master/demo/VID-20241012-WA0018.mp4
### Setup in XML
Add `CurvedBottomNavigationView` in your layout xml file.
```xml
<com.ub.bottomnavigationview.CustomBottomView
        android:id="@+id/nav_view"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:cbn_bg="@color/black"
        app:cbn_dotSize="@dimen/_3sdp"
        app:cbn_textColor="@color/gray"
        app:cbn_dotColor ="@color/green"
        app:cbn_textSize ="@dimen/_8sdp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent" />

```

### Setup in Code
In your `onCreate()` of Activity create a list of `CurvedModel` that you want to appear in the `CurvedBottomNavigationView`.
 Then pass the list to the `setMenuItems()` function that also takes activeIndex(which is 0 by default) 
from which you can control which position item should be active when it is initialized.
```kotlin
 val menuItems = arrayOf(
            CurvedModel(
                R.drawable.ic_home,
                R.drawable.avd_home,
                -1,
                getString(R.string.home)
            ),
            CurvedModel(
                R.drawable.ic_notification,
                R.drawable.avd_notification,
                -1,
                getString(R.string.notifications)
            ),
            CurvedModel(
                R.drawable.ic_settings,
                R.drawable.avd_settings,
                -1,
                getString(R.string.settings_)
            ),
            CurvedModel(
                R.drawable.ic_profile,
                R.drawable.avd_profile,
                -1,
                getString(R.string.profile)
            ),
            CurvedModel(
                R.drawable.ic_dashboard,
                R.drawable.avd_dashboard,
                -1,
                getString(R.string.share)
            )
        )
binding.navView.setMenuItems(menuItems, 2)
```

### Handling Navigation with Listener
To listen whenever the menu item is clicked you can pass a lambda to `setOnMenuItemClickListener`.
```kotlin
   mainBinding.navView.setOnMenuItemClickListener { cbnMenuItem, index ->
            when(index){
                0 -> mainBinding.textView.text = getString(R.string.home)
                1 -> mainBinding.textView.text = getString(R.string.notifications)
                2 -> mainBinding.textView.text = getString(R.string.settings_)
                3 -> mainBinding.textView.text = getString(R.string.profile)
                4 -> mainBinding.textView.text = getString(R.string.share)
            }
        }
```

### Handling Navigaiton with Jetpack Navigation
If you are like me and :heart: Jetpack then there is a method called `setupWithNavController()`
 that accepts `NavController` and will handle the navigaiton for you. Just don't forget to pass the `id` of the destination when you are creating `CurvedModel`.

**Note:** Make sure the home destination in your navigation graph corresponds to the `activeIndex` that you have passed to `setMenuItems()`.
```kotlin
binding.navView.setupWithNavController(navController)
```

### Manually setting the active item
If you need to manually set the active item you can call the `onMenuItemClick()` function and pass in the index that you would like to be selected.
```kotlin
binding.navView.onMenuItemClick(2)
```

### Handling configuration changes
Due to animations, you need to manually handle the configuration changes. You can refer to the sample app for simple implementation.

### XML Attribues
Attribute | Description | Default Value
--------- | ----------- | -------------
app:cbn_selectedColor | Tint for the icon in selected state | `#000000`
app:cbn_unSelectedColor | Tint for the icon in unselected state | `#8F8F8F`
app:cbn_animDuration | Duration in millisecond for the curve animation | `300L`
app:cbn_fabElevation | Elevation for the Floating Action Button | `4dp`
app:cbn_elevation | Elevaton for the Curved Bottom Navigation View | `6dp`
app:cbn_fabBg | Background color of the Floating Action Button | `#FFFFFF`
app:cbn_bg | Background color of the Curved Bottom Navigation | `#FFFFFF`
app:cbn_textColor | text color of the Curved Bottom Navigation | `#FFFFFF`
app:cbn_dotColor | active dot color of the Curved Bottom Navigation | `#FFFFFF`
app:cbn_textSize | text size of the Curved Bottom Navigation | `@dimen/_10sdp`
app:cbn_dotSize | active dot size of the Curved Bottom Navigation | `@dimen/_3sdp`
### Note
The height of the `CurvedBottomNavigationView` is fixed to `56dp` and the size of the `FloatingActionButton` is also fixed to `56dp` for now.
Also the `AnimatedVectorDrawable` animation duration is taken as it is defined in the xml file.
