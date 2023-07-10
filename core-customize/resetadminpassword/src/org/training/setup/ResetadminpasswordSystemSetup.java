/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package org.training.setup;

import static org.training.constants.ResetadminpasswordConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import org.training.constants.ResetadminpasswordConstants;
import org.training.service.ResetadminpasswordService;


@SystemSetup(extension = ResetadminpasswordConstants.EXTENSIONNAME)
public class ResetadminpasswordSystemSetup
{
	private final ResetadminpasswordService resetadminpasswordService;

	public ResetadminpasswordSystemSetup(final ResetadminpasswordService resetadminpasswordService)
	{
		this.resetadminpasswordService = resetadminpasswordService;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		resetadminpasswordService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return ResetadminpasswordSystemSetup.class.getResourceAsStream("/resetadminpassword/sap-hybris-platform.png");
	}
}
