package de.blackforestsolutions.dravelopsdatamodel.objectmothers;

import de.blackforestsolutions.dravelopsdatamodel.CallStatus;
import de.blackforestsolutions.dravelopsdatamodel.GraphQlTab;
import de.blackforestsolutions.dravelopsdatamodel.Status;

public class CallStatusObjectMother {

    public static CallStatus<GraphQlTab> getSuccessfulJourneyCallStatusTab() {
        return new CallStatus<>(GraphQlTab.JOURNEY_QUERY, Status.SUCCESS, null);
    }

    public static CallStatus<GraphQlTab> getFailedJourneyCallStatusTab() {
        return new CallStatus<>(GraphQlTab.JOURNEY_QUERY, Status.FAILED, null);
    }

    public static CallStatus<GraphQlTab> getSuccessfulAddressAutocompletionCallStatusTab() {
        return new CallStatus<>(GraphQlTab.ADDRESS_AUTOCOMPLETION, Status.SUCCESS, null);
    }

    public static CallStatus<GraphQlTab> getFailedAddressAutocompletionCallStatusTab() {
        return new CallStatus<>(GraphQlTab.ADDRESS_AUTOCOMPLETION, Status.FAILED, null);
    }

    public static CallStatus<GraphQlTab> getSuccessfulNearestAddressesCallStatusTab() {
        return new CallStatus<>(GraphQlTab.NEAREST_ADDRESSES, Status.SUCCESS, null);
    }

    public static CallStatus<GraphQlTab> getFailedNearestAddressesCallStatusTab() {
        return new CallStatus<>(GraphQlTab.NEAREST_ADDRESSES, Status.FAILED, null);
    }

    public static CallStatus<GraphQlTab> getSuccessfulNearestStationsCallStatusTab() {
        return new CallStatus<>(GraphQlTab.NEAREST_STATIONS, Status.SUCCESS, null);
    }

    public static CallStatus<GraphQlTab> getFailedNearestStationsCallStatusTab() {
        return new CallStatus<>(GraphQlTab.NEAREST_STATIONS, Status.FAILED, null);
    }
}
