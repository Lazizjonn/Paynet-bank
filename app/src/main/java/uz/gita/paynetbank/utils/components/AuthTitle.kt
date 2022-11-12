package uz.gita.paynetbank.utils.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign

@Composable
fun AuthTitle(
    modifier: Modifier = Modifier,
    text: Int,
    style: TextStyle = MaterialTheme.typography.h5.copy(
        color = MaterialTheme.colors.onSurface,
        textAlign = TextAlign.Center
    )
) {
    Text(
        modifier = modifier.fillMaxWidth(),
        text = stringResource(id = text),
        style = style
    )
}