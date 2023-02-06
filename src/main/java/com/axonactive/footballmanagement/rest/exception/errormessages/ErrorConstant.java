package com.axonactive.footballmanagement.rest.exception.errormessages;

public class ErrorConstant {
    public static final String MSG_DATE_FORMAT_NOT_VALID = "Date format is not valid";
    public static final String MSG_REQUEST_EMPTY = "Request empty";
    public static final String MSG_NOT_FOUND = "%s not found";
    public static final String MSG_IDPATHPARAM_CONFLICT_IDBODY = "Different id between pathparam and request body";
    public static final String MSG_PLAYER_IDPATHPARAM_CONFLICT_IDBODY = "Different player id between pathparam and request body";
    public static final String MSG_TEAM_IDPATHPARAM_CONFLICT_IDBODY = "Different team id between pathparam and request body";
    public static final String MSG_ID_PROVIDED_IN_CREATE_METHOD = "Not allow provide id in create method";
    public static final String MSG_EXIST_CURRENT_PLAYER = "Player is playing for a team";
    public static final String MSG_LEAVEDATE_IS_BEFORE_ATTENDDATE = "Leave date is before attend date";
    public static final String MSG_ATTENDDATE_IS_BEFORE_LAST_LEAVEDATE = "Attend date is before last leave date";
    public static final String MSG_MAX_ACTIVE_PLAYERS = "Number of active players reach maximum";
}
