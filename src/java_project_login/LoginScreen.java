package java_project_login;

/**
 *
 * @author 20143701 최유래
 * state pattern
 * 현재 상태를 반영하는 state 객체를 가리키는 객체 클래스(context object) 
 */

public class LoginScreen {

    State successState;
    State failState;
    State notInputState;
    State inputState;
    State state = notInputState;

    UserInfo userinfo = new UserInfo();

    public LoginScreen() {
        successState = new SuccessState(this);
        failState = new FailState(this);
        notInputState = new NotInputState(this);
        inputState = new InputState(this, userinfo);

        state = notInputState;
    }

    public State getSuccessState() {
        return successState;
    }

    public State getFailState() {
        return failState;
    }

    public State getNotInputState() {
        return notInputState;
    }

    public State getInputState(UserInfo userinfo) {
        this.userinfo = userinfo;
        inputState = new InputState(this, userinfo);
        return inputState;
    }

    public boolean resultPrint() {
       return state.resultPrint();
    }

    public UserInfo inputData() {
        return state.inputData();
    }

    public boolean compareDB(UserInfo userinfo) {
        return state.compareDB(userinfo);
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }
}
