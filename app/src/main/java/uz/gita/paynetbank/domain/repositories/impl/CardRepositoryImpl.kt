package uz.gita.mobilebanking.domain.repositories.impl

import uz.gita.paynetbank.data.source.local.sharedPref.MySharedPref
import uz.gita.mobilebanking.domain.repositories.CardRepository
import javax.inject.Inject

class CardRepositoryImpl @Inject constructor(
    private val sharedPref: MySharedPref
): CardRepository {

}