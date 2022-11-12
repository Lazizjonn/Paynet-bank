package uz.gita.paynetbank.presentation.ui.onboarding

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import com.github.terrakok.modo.android.compose.ComposeScreen
import com.github.terrakok.modo.android.compose.uniqueScreenKey
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch
import kotlinx.parcelize.Parcelize
import uz.gita.paynetbank.R
import uz.gita.paynetbank.presentation.ui.onboarding.components.DotsIndicator
import uz.gita.paynetbank.utils.components.TextHint
import uz.gita.paynetbank.utils.theme.PaynetBankTheme
import uz.gita.paynetbank.utils.theme.spacing


@Parcelize
class OnBoardingScreen(override val screenKey: String = uniqueScreenKey) : ComposeScreen(id = "OnBoardingScreen") {

    @Composable
    override fun Content() {
        val viewModel: OnBoardingViewModel = viewModel<OnBoardingViewModelImpl>()
        val uiState = viewModel.onBoardingUiState.collectAsState()
        OnBoardingScreenContent(onBoardingUiState = uiState, eventDispatcher = viewModel::eventDispatcher)
    }
}


@[Composable OptIn(ExperimentalPagerApi::class)]
fun OnBoardingScreenContent(
    onBoardingUiState: State<OnBoardingUiState>,
    eventDispatcher: (OnBoardingIntent) -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.surface
    ) {
        ConstraintLayout {
            val (skipButton, pager, dotsIndicator, nextButton, startButton) = createRefs()
            val startGuideLine = createGuidelineFromStart(0.5f)
            val onboardData by remember { mutableStateOf(OnBoardingUiState().onboardList) }
            val pagerState = rememberPagerState()
            val coroutineScope = rememberCoroutineScope()

            TextHint(
                modifier = Modifier
                    .padding(
                        top = MaterialTheme.spacing.spacing_24dp,
                        end = MaterialTheme.spacing.spacing_24dp
                    )
                    .constrainAs(skipButton) {
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                    }
                    .clickable {
                        eventDispatcher(OnBoardingIntent.SKIP)
                    },
                text = R.string.dismiss,
            )

            HorizontalPager(
                modifier = Modifier
                    .constrainAs(pager) {
                        linkTo(start = parent.start, end = parent.end)
                        linkTo(top = parent.top, bottom = parent.bottom)
                    }
                    .fillMaxSize(),
                count = onboardData.size,
                state = pagerState
            ) { page ->

                Column(
                    modifier = Modifier
                        .padding(bottom = MaterialTheme.spacing.spacing_64dp)
                ) {
                    Image(
                        modifier = androidx.compose.ui.Modifier.padding(MaterialTheme.spacing.spacing_64dp),
                        painter = painterResource(id = onboardData[page].image),
                        contentDescription = ""
                    )
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = stringResource(id = onboardData[page].title),
                        style = MaterialTheme.typography.h4.copy(textAlign = TextAlign.Center)
                    )
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                top = MaterialTheme.spacing.spacing_8dp,
                                bottom = MaterialTheme.spacing.spacing_32dp
                            ),
                        text = stringResource(id = onboardData[page].description),
                        style = MaterialTheme.typography.body1.copy(textAlign = TextAlign.Center)
                    )
                }

            }

            val backHandlerEnabled by remember { mutableStateOf(true) }
            BackHandler(enabled = backHandlerEnabled) {
                if (pagerState.currentPage != 0) coroutineScope.launch {
                    pagerState.animateScrollToPage(
                        pagerState.currentPage - 1
                    )
                }
            }

            DotsIndicator(
                modifier = Modifier
                    .padding(
                        start = MaterialTheme.spacing.spacing_24dp,
                        bottom = MaterialTheme.spacing.spacing_24dp
                    )
                    .constrainAs(dotsIndicator) {
                        start.linkTo(parent.start)
                        bottom.linkTo(parent.bottom)
                    },
                totalDots = onboardData.size,
                selectedIndex = pagerState.currentPage
            )

            if (pagerState.currentPage != onboardData.size - 1) {
                Text(
                    modifier = Modifier
                        .padding(
                            end = MaterialTheme.spacing.spacing_24dp,
                            bottom = MaterialTheme.spacing.spacing_16dp
                        )
                        .constrainAs(nextButton) {
                            end.linkTo(parent.end)
                            bottom.linkTo(parent.bottom)
                        }
                        .clickable {
                            if (pagerState.currentPage != pagerState.pageCount - 1) {
                                coroutineScope.launch {
                                    pagerState.animateScrollToPage(pagerState.currentPage + 1)
                                }
                            }
                        },
                    text = stringResource(id = R.string.next)
                )
            } else {
                Button(
                    modifier = Modifier
                        .padding(
                            start = MaterialTheme.spacing.spacing_24dp,
                            end = MaterialTheme.spacing.spacing_24dp,
                            bottom = MaterialTheme.spacing.spacing_8dp
                        )
                        .constrainAs(startButton) {
                            start.linkTo(startGuideLine)
                            end.linkTo(parent.end)
                            bottom.linkTo(parent.bottom)
                        }
                        .fillMaxWidth(0.5f)
                        .height(48.dp),
                    onClick = {
                        eventDispatcher(OnBoardingIntent.SKIP)
                    },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.secondary
                    ),
                    shape = MaterialTheme.shapes.medium
                ) {
                    Text(
                        text = stringResource(id = R.string.start),
                        style = MaterialTheme.typography.button
                    )
                }

            }
        }
    }
}


@[Composable Preview SuppressLint("UnrememberedMutableState")]
fun PreviewOnBoardingScreen() {
    PaynetBankTheme {
        OnBoardingScreenContent(mutableStateOf(OnBoardingUiState())) {}
    }
}
