package uz.gita.paynetbank.utils.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import uz.gita.paynetbank.R
import uz.gita.paynetbank.utils.theme.spacing

@Composable
fun AuthButton(
    modifier: Modifier,
    text: Int,
    enabled: Boolean,
    onClick: () -> Unit,
) {
    Button(
        onClick = { onClick.invoke() },
        modifier = modifier
            .height(MaterialTheme.spacing.spacing_48dp)
            .fillMaxWidth(),
        enabled = enabled,
        shape = MaterialTheme.shapes.medium,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = when (enabled) {
                false -> MaterialTheme.colors.secondaryVariant
                else -> MaterialTheme.colors.secondary
            }
        )
    ) {
        Text(
            text = stringResource(id = text),
            color = when (enabled) {
                false -> colorResource(id = R.color.text_light_gray)
                else -> colorResource(id = R.color.text_white)
            },
            style = MaterialTheme.typography.button
        )
    }
}