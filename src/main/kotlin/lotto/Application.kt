package lotto

import camp.nextstep.edu.missionutils.Randoms
import kotlin.math.round

const val LOTTERY_PRICE = 1000
const val LOTTERY_SIZE = 6
const val TAG = "ERROR"
val NUMBER_RANGE = 1..45

/**
 * @param money : user money to purchase lotto
 * @return List of Lotto that user bought
 */
fun buyLottery(money: Int): List<Lotto> {
    val lotteryList = mutableListOf<Lotto>()
    val numOfLotteries = money / LOTTERY_PRICE
    for(i in 1..numOfLotteries) {
        lotteryList.add(Lotto(Randoms.pickUniqueNumbersInRange(NUMBER_RANGE.first, NUMBER_RANGE.last, 6)))
    }
    return lotteryList
}

/**
 * @param winnings : map of (prize, the number of lotto won that prize)
 * @param money : money spent on purchasing lotto
 * @return rate of return
 */
fun calculateEarnings(winnings: Map<Prize,Int>, money: Int): Double {
    var totalPrize = 0
    for(prize in winnings) {
        totalPrize += prize.key.earnings * prize.value
    }
    return round(totalPrize.toDouble()/money.toDouble()*1000) /10.0
}

fun main() {
    TODO("프로그램 구현")
}
