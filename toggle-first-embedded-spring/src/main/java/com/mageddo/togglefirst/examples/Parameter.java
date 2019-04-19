package com.mageddo.togglefirst.examples;

import com.mageddo.togglefirst.*;

public enum Parameter implements InteractiveFeature {

	@FeatureDefaults(status = Status.ACTIVE, value = "Congrats!")
	FREE_SHOP,

	BALANCE
	;

	@Override
	public FeatureManager manager() {
		return FeatureContext.getFeatureManager();
	}
}
