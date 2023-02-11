package ru.toxyxd.feature.server.clients.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AdminPanelSettings
import androidx.compose.material.icons.rounded.Android
import androidx.compose.material.icons.rounded.ChildFriendly
import androidx.compose.material.icons.rounded.Computer
import androidx.compose.material.icons.rounded.DeviceUnknown
import androidx.compose.material.icons.rounded.Headphones
import androidx.compose.material.icons.rounded.IosShare
import androidx.compose.material.icons.rounded.Laptop
import androidx.compose.material.icons.rounded.LaptopMac
import androidx.compose.material.icons.rounded.LaptopWindows
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.PhotoCamera
import androidx.compose.material.icons.rounded.Print
import androidx.compose.material.icons.rounded.Security
import androidx.compose.material.icons.rounded.Smartphone
import androidx.compose.material.icons.rounded.Storage
import androidx.compose.material.icons.rounded.Tablet
import androidx.compose.material.icons.rounded.Tv
import androidx.compose.material.icons.rounded.VideogameAsset
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import ru.toxyxd.feature.server.R

@Composable
fun ClientIcon(
    deviceTag: String,
    modifier: Modifier = Modifier
) {
    Icon(
        imageVector = when (deviceTag) {
            "device_audio" -> Icons.Rounded.Headphones
            "device_camera" -> Icons.Rounded.PhotoCamera
            "device_gameconsole" -> Icons.Rounded.VideogameAsset
            "device_laptop" -> Icons.Rounded.Laptop
            "device_nas" -> Icons.Rounded.Storage
            "device_other" -> Icons.Rounded.DeviceUnknown
            "device_pc" -> Icons.Rounded.Computer
            "device_phone" -> Icons.Rounded.Smartphone
            "device_printer" -> Icons.Rounded.Print
            "device_securityalarm" -> Icons.Rounded.Security
            "device_tablet" -> Icons.Rounded.Tablet
            "device_tv" -> Icons.Rounded.Tv
            "os_android" -> Icons.Rounded.Android
            "os_ios" -> Icons.Rounded.IosShare
            "os_linux" -> ImageVector.vectorResource(R.drawable.ic_linux)
            "os_macos" -> Icons.Rounded.LaptopMac
            "os_other" -> Icons.Rounded.DeviceUnknown
            "os_windows" -> Icons.Rounded.LaptopWindows
            "user_admin" -> Icons.Rounded.AdminPanelSettings
            "user_child" -> Icons.Rounded.ChildFriendly
            "user_regular" -> Icons.Rounded.Person
            else -> Icons.Rounded.DeviceUnknown
        },
        contentDescription = deviceTag,
        modifier = modifier
    )
}

