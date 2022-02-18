package ru.fylmr.poplibs_nov21.di.component

import dagger.Subcomponent
import ru.fylmr.poplibs_nov21.di.modules.RepoModule
import ru.fylmr.poplibs_nov21.di.scope.RepoScope
import ru.fylmr.poplibs_nov21.ui.repos.ReposPresenterFactory

@Subcomponent(
    modules = [RepoModule::class]
)
@RepoScope
interface RepoSubcomponent {

    fun provideReposPresenterFactory(): ReposPresenterFactory
}