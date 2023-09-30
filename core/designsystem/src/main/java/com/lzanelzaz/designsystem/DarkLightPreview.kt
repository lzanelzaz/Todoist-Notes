package com.lzanelzaz.designsystem

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_NO, name = "Light mode")
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES, name = "Dark mode")
annotation class DarkLightPreview
