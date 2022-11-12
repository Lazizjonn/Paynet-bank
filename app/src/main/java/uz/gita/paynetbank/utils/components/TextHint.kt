package uz.gita.paynetbank.utils.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import uz.gita.paynetbank.R
import uz.gita.paynetbank.utils.theme.PaynetBankTheme

@Composable
fun TextHint(
    modifier: Modifier = Modifier,
    text: Int
) {
    Text(
        modifier = modifier,
        text = stringResource(id = text),
        style = MaterialTheme.typography.caption.copy(
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
        )
    )
}

@[Preview Composable]
private fun TextHintPreview() {
    PaynetBankTheme {
        TextHint(modifier = Modifier, text = R.string.text_bank)
    }
}