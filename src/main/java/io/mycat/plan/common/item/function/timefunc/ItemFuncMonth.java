package io.mycat.plan.common.item.function.timefunc;

import java.math.BigInteger;
import java.util.List;

import io.mycat.plan.common.item.Item;
import io.mycat.plan.common.item.function.primary.ItemIntFunc;
import io.mycat.plan.common.time.MySQLTime;
import io.mycat.plan.common.time.MyTime;

public class ItemFuncMonth extends ItemIntFunc {

	public ItemFuncMonth(List<Item> args) {
		super(args);
	}

	@Override
	public final String funcName() {
		return "month";
	}

	@Override
	public BigInteger valInt() {
		MySQLTime ltime = new MySQLTime();
		return getArg0Date(ltime, MyTime.TIME_FUZZY_DATE) ? BigInteger.ZERO : BigInteger.valueOf(ltime.month);
	}

	@Override
	public void fixLengthAndDec() {
		maxLength = (2);
		maybeNull = true;
	}
}