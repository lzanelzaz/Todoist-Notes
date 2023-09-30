package com.lzanelzaz.designsystem.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lzanelzaz.designsystem.DarkLightPreview
import com.lzanelzaz.designsystem.theme.TdnTheme

@Composable
fun TdnButton(
   /* onClick: () -> Unit,
              modifier: Modifier,
              enabled: Boolean,
              content: @Composable() (RowScope.() -> Unit)*/
) {
    Button(onClick = {}, shape = RoundedCornerShape(20.dp)) {
        Box(
            contentAlignment = Alignment.Center, modifier = Modifier
                .heightIn(min = 32.dp)
                .width(50.dp)
        ) {
            Text("+")
        }
    }
}

@Composable
@DarkLightPreview
fun TdnButtonPreview() {
    TdnTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            TdnButton()
        }
    }
}
