package com.asura.design_patterns.state

/**
 * @author Created by Asura on 2018/4/16 10:37.
 */
class LoginContext {
    //默认为未登录状态
    var userState: UserState = LogoutState()

    private constructor()

    companion object {
        private var context: LoginContext? = null

        //获取单例
        public fun getInstance(): LoginContext? {
            if (context == null) {
                synchronized(LoginContext::class.java) {
                    if (context == null) {
                        context = LoginContext()
                    }
                }
            }
            return context
        }
    }

    public fun setState(userState: UserState) {
        this.userState = userState
    }

    public fun forward() {
        userState.forward()
    }

    public fun comment() {
        userState.comment()
    }

}