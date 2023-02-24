package com.axonactive.footballmanagement.rest.exception.errormessages;

public class ErrorConstant {
    public static final String MSG_DATE_FORMAT_NOT_VALID = "Date format is not valid";
    public static final String MSG_REQUEST_EMPTY = "Request empty";
    public static final String MSG_NOT_FOUND = "%s not found";
    public static final String MSG_IDPATHPARAM_CONFLICT_IDBODY = "Different id between pathparam and request body";
    public static final String MSG_PLAYER_IDPATHPARAM_CONFLICT_IDBODY = "Different player id between pathparam and request body";
    public static final String MSG_TEAM_IDPATHPARAM_CONFLICT_IDBODY = "Different team id between pathparam and request body";
    public static final String MSG_LEAGUE_IDPATHPARAM_CONFLICT_IDBODY = "Different league id between pathparam and request body";
    public static final String MSG_ID_PROVIDED_IN_CREATE_METHOD = "Not allow provide id in create method";
    public static final String MSG_EXIST_CURRENT_PLAYER = "Player is playing for a team";
    public static final String MSG_LEAGUE_NOT_END_YET = "League isn't over yet";
    public static final String MSG_LEAVEDATE_IS_NOT_AFTER_ATTENDDATE = "Leave date is not after attend date";
    public static final String MSG_ENDDATE_IS_BEFORE_STARTDATE = "End date is before start date";
    public static final String MSG_LAST_LEAVEDATE_IS_BEFORE_ATTENDDATE = "Last leave date is before attend date";
    public static final String MSG_INCONSISTENT_ISCURRENT_DATE_RANGE = "Inconsistent isCurrent and date range";
    public static final String MSG_LEAVEDATE_NOT_NULL = "Leave date must not be null";
    public static final String MSG_LEAVEDATE_NULL = "Leave date must be null";
    public static final String MSG_STARTDATE_IS_BEFORE_LAST_ENDDATE = "Start date is before last end date";
    public static final String MSG_MAX_ACTIVE_PLAYERS = "Number of active players reach maximum";
    public static final String MSG_EXIST_OBJECT_ON_DATE = "There is a record on this date";
    public static final String MSG_WRONG_ACTIVE_PLAYER = "Can not active this player";
}
