package ru.fylmr.poplibs_nov21

import android.app.Application
import ru.fylmr.poplibs_nov21.di.component.DaggerAppComponent
import ru.fylmr.poplibs_nov21.di.component.RepoSubcomponent
import ru.fylmr.poplibs_nov21.di.component.UserSubcomponent
import ru.fylmr.poplibs_nov21.di.modules.ContextModule

class App : Application() {

    val appComponent by lazy {
        DaggerAppComponent.builder()
            .contextModule(ContextModule(this))
            .build()
    }

    var usersSubcomponent: UserSubcomponent? = null
        private set
    var reposSubcomponent: RepoSubcomponent? = null
        private set

    override fun onCreate() {
        super.onCreate()
        _instance = this
    }

    fun initUserSubcomponent(): UserSubcomponent {
        usersSubcomponent = appComponent.userSubcomponent()
        return usersSubcomponent!!
    }

    fun initRepoSubcomponent(): RepoSubcomponent {
        reposSubcomponent = appComponent.userSubcomponent().repoSubcomponent()
        return reposSubcomponent!!
    }

    fun destroyRepoScope() {
        reposSubcomponent = null
    }

    fun destroyUserScope() {
        usersSubcomponent = null
    }

    companion object {

        private var _instance: App? = null
        val instance
            get() = _instance!!
    }
}