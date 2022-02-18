package ru.fylmr.poplibs_nov21.di.component

import dagger.Subcomponent

import ru.fylmr.poplibs_nov21.di.modules.RepositoryModule
import ru.fylmr.poplibs_nov21.di.scope.RepoScope
import ru.fylmr.poplibs_nov21.ui.repos.ReposPresenterFactory

@Subcomponent(
    modules = [RepositoryModule::class]
)
@RepoScope
interface RepoSubcomponent {

    fun provideReposPresenterFactory(): ReposPresenterFactory
}