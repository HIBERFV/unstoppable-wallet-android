package io.horizontalsystems.bankwallet.modules.transactions

import android.content.Context
import android.text.TextPaint
import android.text.TextUtils
import io.horizontalsystems.bankwallet.R
import io.horizontalsystems.bankwallet.entities.transactionrecords.bitcoin.TransactionLockState

object TransactionViewHelper {

    private val paint = TextPaint()

    fun getLockIcon(lockState: TransactionLockState?) = when {
        lockState == null -> 0
        lockState.locked -> R.drawable.ic_lock_20
        else -> R.drawable.ic_unlock_20
    }

    fun truncated(string: String, available: Float): CharSequence {
        return TextUtils.ellipsize(string, paint, available, TextUtils.TruncateAt.MIDDLE)
    }

    fun getAmountColor(type: TransactionType, context: Context): Int {
        val color = R.color.leah
//                when (type) {
//            TransactionType.Outgoing, TransactionType.SentToSelf -> R.color.jacob
//            TransactionType.Incoming -> R.color.remus
//            TransactionType.Approve -> R.color.leah
//        }

        return context.getColor(color)
    }

    fun getTransactionTypeIcon(type: TransactionType): Int {
        return R.drawable.ic_outgoing_20
//        when (type) {
//            TransactionType.Outgoing, TransactionType.SentToSelf -> R.drawable.ic_outgoing_20
//            TransactionType.Incoming -> R.drawable.ic_incoming_20
//            TransactionType.Approve -> R.drawable.ic_swap_approval_20
//        }
    }

    fun getBottomIconImage(status: TransactionStatus): Int? {
        return when (status) {
            is TransactionStatus.Failed -> R.drawable.ic_attention_red_20
            is TransactionStatus.Completed -> R.drawable.ic_checkmark_20
            else -> null
        }
    }
}
