package ru.fylmr.poplibs_nov21.di.component

import dagger.Subcomponent
import ru.fylmr.poplibs_nov21.di.modules.UserModule
import ru.fylmr.poplibs_nov21.di.scope.UserScope
import ru.fylmr.poplibs_nov21.ui.users.UsersPresenter

@Subcomponent(
    modules = [
        UserModule::class,
    ]
)
@UserScope
interface UserSubcomponent {

    fun repoSubcomponent(): RepoSubcomponent

    fun provideUsersPresenter(): UsersPresenter
}