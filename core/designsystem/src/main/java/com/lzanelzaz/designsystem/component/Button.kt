package com.lzanelzaz.designsystem.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lzanelzaz.designsystem.theme.TdnTheme

/**
 * Todoist Notes filled button with generic content slot.
 * Wraps Material 3 [Button].
 *
 * @param onClick called when this button is clicked
 * @param modifier the [Modifier] to be applied to this button
 * @param enabled controls the enabled state of this button. When `false`, this component will not
 * respond to user input
 * @param contentPadding the spacing values to apply internally between the container and the content
 * @param buttonColor [Color] to apply to the container
 * @param textColor [Color] to apply to the text
 */
@Composable
fun TdnButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentPadding: PaddingValues = PaddingValues(TdnButtonDefaults.cornerRadius.dp),
    buttonColor: Color = MaterialTheme.colorScheme.primary,
    textColor: Color = MaterialTheme.colorScheme.background,
    content: @Composable (RowScope.() -> Unit)
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        contentPadding = contentPadding,
        shape = RoundedCornerShape(TdnButtonDefaults.cornerRadius.dp),
        colors = ButtonDefaults.textButtonColors(
            containerColor = buttonColor,
            contentColor = textColor
        ),
        content = content
    )
}

/**
 * Todoist Notes filled button with text and leading icon (optional) content slots.
 * Wraps Material 3 [Button].
 *
 * @param onClick called when this button is clicked
 * @param modifier the [Modifier] to be applied to this button
 * @param enabled controls the enabled state of this button. When `false`, this component will not
 * respond to user input
 * @param contentPadding the spacing values to apply internally between the container and the content
 * @param buttonColor [Color] to apply to the container
 * @param textColor [Color] to apply to the text
 * @param text The button text label content
 * @param leadingIcon The button leading icon content. Pass `null` here for no leading icon
 */
@Composable
fun TdnTextButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentPadding: PaddingValues = PaddingValues(TdnButtonDefaults.cornerRadius.dp),
    buttonColor: Color = MaterialTheme.colorScheme.primary,
    textColor: Color = MaterialTheme.colorScheme.background,
    text: @Composable (() -> Unit),
    leadingIcon: @Composable (() -> Unit)? = null
) {
    TdnButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        buttonColor = buttonColor,
        textColor = textColor,
        contentPadding = contentPadding,
    ) {
        if (leadingIcon != null) {
            Box(
                Modifier.padding(end = ButtonDefaults.IconSpacing)
            ) {
                leadingIcon()
            }
        }
        text()
    }
}

@Composable
@DarkLightPreview
fun TdnButtonDefaultPreview() {
    TdnTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            TdnButton(onClick = {}) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }
    }
}

@Composable
@DarkLightPreview
fun TdnTextButtonDefaultPreview() {
    TdnTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            TdnTextButton(
                onClick = {},
                text = {
                    Text(
                        text = "Sign up with email",
                        fontWeight = FontWeight.SemiBold
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                contentPadding = ButtonDefaults.ContentPadding
            )
        }
    }
}

@Composable
@DarkLightPreview
fun TdnTextWithIconButtonDefaultPreview() {
    TdnTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            TdnTextButton(
                onClick = {},
                text = {
                    Text(
                        text = "Sign up with email",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.ExitToApp,
                        contentDescription = null
                    )
                },
                buttonColor = Color(0xFF95CFD6),
                textColor = Color(0xFF29282C)
            )
        }
    }
}

object TdnButtonDefaults {
    const val cornerRadius = 20
}

