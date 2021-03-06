package org.openmrs.module.appointmentschedulingui.fragment.controller;

import org.openmrs.Patient;
import org.openmrs.module.appointmentschedulingui.AppointmentSchedulingUIConstants;
import org.openmrs.module.appui.UiSessionContext;
import org.openmrs.module.emrapi.patient.PatientDomainWrapper;
import org.openmrs.ui.framework.annotation.InjectBeans;
import org.openmrs.ui.framework.page.PageModel;
import org.springframework.web.bind.annotation.RequestParam;

public class AppointmentsTabFragmentController {

    public Object controller(@RequestParam("patientId") Patient patient, UiSessionContext uiSessionContext,
                             PageModel model, @InjectBeans PatientDomainWrapper patientDomainWrapper) {

        patientDomainWrapper.setPatient(patient);
        model.addAttribute("patient", patientDomainWrapper);
        model.addAttribute("canBook", uiSessionContext.getCurrentUser().hasPrivilege(AppointmentSchedulingUIConstants.PRIVILEGE_BOOK_APPOINTMENTS));

        return null;
    }

}
