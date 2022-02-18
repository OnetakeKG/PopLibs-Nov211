package ru.fylmr.poplibs_nov21.di.modules

import dagger.Module
import dagger.Provides
import ru.fylmr.poplibs_nov21.db.dao.ReposDao
import ru.fylmr.poplibs_nov21.di.scope.RepoScope
import ru.fylmr.poplibs_nov21.domain.repos.GithubReposRepository
import ru.fylmr.poplibs_nov21.domain.repos.IGithubReposRepository
import ru.fylmr.poplibs_nov21.network.GithubApiService
import ru.fylmr.poplibs_nov21.network.NetworkStatus

@Module
class RepoModule {

    @Provides
    @RepoScope
    fun provideRepoRepository(
        apiService: GithubApiService,
        reposDao: ReposDao,
        networkStatus: NetworkStatus
    ): IGithubReposRepository {
        return GithubReposRepository(apiService, reposDao, networkStatus)
    }
}