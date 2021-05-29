package com.laksana.themovies.utils

import com.laksana.themovies.data.source.remote.response.ResultsItem
import com.laksana.themovies.data.source.remote.response.TVShowResultsItem
import com.laksana.themovies.model.DataModel
import com.laksana.themovies.model.TvShowModel

object DataDummy {
    fun listMoviesResponse() : ArrayList<ResultsItem> {
        val listMovieResponse = ArrayList<ResultsItem>()

        listMovieResponse.add(
            ResultsItem(
                overview = "A rowdy, unorthodox Santa Claus is fighting to save his declining business. Meanwhile, Billy, a neglected and precocious 12 year old, hires a hit man to kill Santa after receiving a lump of coal in his stocking.",
                originalLanguage = "en",
                title = "Fatman",
                posterPath = "https://image.tmdb.org/t/p/original/4n8QNNdk4BOX9Dslfbz5Dy6j1HK.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/8lUbAZsJ8hJyanTFFRxzawlCwns.jpg",
                releaseDate = "Nov 13, 2020",
                id = 602211,
            )
        )
        return listMovieResponse
    }

    fun listTvShowResponse() : ArrayList<TVShowResultsItem>{
        val listTvShowResponse = ArrayList<TVShowResultsItem>()

        listTvShowResponse.add(
            TVShowResultsItem(
                firstAirDate = "Nov 12, 2019",
                overview = "After the fall of the Galactic Empire, lawlessness has spread throughout the galaxy. A lone gunfighter makes his way through the outer reaches, earning his keep as a bounty hunter.",
                originalLanguage = "en",
                posterPath = "https://image.tmdb.org/t/p/original/sWgBv7LV2PRoQgkxwlibdGXKz1S.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/o7qi2v4uWQ8bZ1tW3KI0Ztn2epk.jpg",
                name = "The Mandalorian",
                id = 11,
            )
        )
        return listTvShowResponse
    }

    fun listMovies(): List<DataModel> {
        val listMovie = ArrayList<DataModel>()

        listMovie.add(
            DataModel(
                id = 1,
                title = "Hard Kill",
                overview = "The work of billionaire tech CEO Donovan Chalmers is so valuable that he hires mercenaries to protect it, and a terrorist group kidnaps his daughter just to get it.",
                poster = "https://image.tmdb.org/t/p/original/A885WHVvtvaJXgzRMBE6VQqZDIM.jpg",
                release = "23 October 2020",
                imgBackground = "https://image.tmdb.org/t/p/original/86L8wqGMDbwURPni2t7FQ0nDjsH.jpg"
            )
        )

        listMovie.add(
            DataModel(
                id = 2,
                title = "Kickboxer: Retaliation",
                overview = "One year after the events of \"Kickboxer: Vengeance\", Kurt Sloan has vowed never to return to Thailand. However, while gearing up for a MMA title shot, he finds himself sedated and forced back into Thailand, this time in prison. He is there because the ones responsible want him to face a 6'8\" 400 lbs. beast named Mongkut and in return for the fight, Kurt will get two million dollars and his freedom back. Kurt at first refuses, in which a bounty is placed on his head as a way to force him to face Mongkut. Kurt soon learns he will have no other choice and will undergo his most rigorous training yet under some unexpected mentors in order to face Mongkut in hopes to regain his freedom.",
                poster = "https://image.tmdb.org/t/p/original/6eQk2X05p0bgCZCuh67a4dwJvEw.jpg",
                release = "Jan 26, 2018",
                imgBackground = "https://image.tmdb.org/t/p/original/nTH63dIC9D9lWhQlvCu4zSoESKj.jpg"
            )
        )

        listMovie.add(
            DataModel(
                id = 590706,
                title = "Jiu Jitsu",
                overview = "Every six years, an ancient order of jiu-jitsu fighters joins forces to battle a vicious race of alien invaders. But when a celebrated war hero goes down in defeat, the fate of the planet and mankind hangs in the balance.",
                poster = "https://image.tmdb.org/t/p/original/lOicKkOW7j8YIGmBtBzriEyEfvM.jpg",
                release = "Nov 20, 2020",
                imgBackground = "https://image.tmdb.org/t/p/original/lfO0BjbxPT5NMlw1JUv7fQqDHwt.jpg"
            )
        )

        listMovie.add(
            DataModel(
                id= 577922,
                title = "Tenet",
                overview = "Armed with only one word - Tenet - and fighting for the survival of the entire world, the Protagonist journeys through a twilight world of international espionage on a mission that will unfold in something beyond real time.",
                poster = "https://image.tmdb.org/t/p/original/oRkLA2EkXaRLmK63BkvK74G8tC4.jpg",
                release = "Ags 26, 2020",
                imgBackground = "https://image.tmdb.org/t/p/original/wzJRB4MKi3yK138bJyuL9nx47y6.jpg"
            )
        )

        listMovie.add(
            DataModel(
                id = 3,
                title = "Host",
                overview = "Six friends hire a medium to hold a séance via Zoom during lockdown — but they get far more than they bargained for as things quickly go wrong. When an evil spirit starts invading their homes, they begin to realize they might not survive the night.",
                poster = "https://image.tmdb.org/t/p/original/BGFm9YaerOGelQbNAjxELYDNCj.jpg",
                release = "Nov 27, 2020",
                imgBackground = "https://image.tmdb.org/t/p/original/5TbtcmRySXPAEXBzwhiOYYDQmgv.jpg"
            )
        )

        listMovie.add(
            DataModel(
                id = 4,
                title = "Parallel",
                overview = "A group of friends stumble upon a mirror that serves as a portal to a \"multiverse\", but soon discover that importing knowledge from the other side in order to better their lives brings increasingly dangerous consequences.",
                poster = "https://image.tmdb.org/t/p/original/2KzrhGKQ2oQUhGU0dBUxXy8IELE.jpg",
                release = "Des 11, 2020",
                imgBackground = "https://image.tmdb.org/t/p/original/5TbtcmRySXPAEXBzwhiOYYDQmgv.jpg"
            )
        )

        listMovie.add(
            DataModel(
                id = 5,
                title = "Archenemy",
                overview = "Max Fist claims he’s a hero from another dimension who has somehow landed on Earth and been stripped of his powers. Instead of treating him like a powerful champion, no one believes Max’s claims — except for a teenager named Hamster and his sister Indigo. The siblings convince Max to help them take out a local drug gang, where Max’s abilities are put to a violent and harrowing test.",
                poster = "https://image.tmdb.org/t/p/original/o4oDQ9XUG7uQefdEVIOfT6yi86y.jpg",
                release = "Des 11, 2020",
                imgBackground = "https://image.tmdb.org/t/p/original/1vLDpJDsjUpV7NCmJEGOin22stw.jpg"
            )
        )

        listMovie.add(
            DataModel(
                id = 6,
                title = "Mulan",
                overview = "When the Emperor of China issues a decree that one man per family must serve in the Imperial Chinese Army to defend the country from Huns, Hua Mulan, the eldest daughter of an honored warrior, steps in to take the place of her ailing father. She is spirited, determined and quick on her feet. Disguised as a man by the name of Hua Jun, she is tested every step of the way and must harness her innermost strength and embrace her true potential.",
                poster = "https://image.tmdb.org/t/p/original/ffVoswXHDZvyi53yJ1Q4rb9I60q.jpg",
                release = "Sep 4, 2020",
                imgBackground = "https://image.tmdb.org/t/p/original/aoHiMjRt0Qs1dtkV61LyxTnQtJl.jpg"
            )
        )

        listMovie.add(
            DataModel(
                id = 7,
                title = "Greenland",
                overview = "John Garrity, his estranged wife and their young son embark on a perilous journey to find sanctuary as a planet-killing comet hurtles toward Earth. Amid terrifying accounts of cities getting levelled, the Garrity's experience the best and worst in humanity. As the countdown to the global apocalypse approaches zero, their incredible trek culminates in a desperate and last-minute flight to a possible safe haven.",
                poster = "https://image.tmdb.org/t/p/original/bCr4uoYd3iZHEgxCoL49qP0WJaE.jpg",
                release = "Jul 29, 2020",
                imgBackground = "https://image.tmdb.org/t/p/original/gaqWbJ9Qde3z9xlvGh3FtIn7e40.jpg"
            )
        )
        return listMovie
    }

    fun listTvShows() : List<TvShowModel> {
        val listTvShow = ArrayList<TvShowModel>()

        listTvShow.add (
            TvShowModel(
                id = 11,
                name = "The Mandalorian",
                overview = "After the fall of the Galactic Empire, lawlessness has spread throughout the galaxy. A lone gunfighter makes his way through the outer reaches, earning his keep as a bounty hunter.",
                poster = "https://image.tmdb.org/t/p/original/sWgBv7LV2PRoQgkxwlibdGXKz1S.jpg",
                release = "Nov 12, 2019",
                imgBackground = "https://image.tmdb.org/t/p/original/o7qi2v4uWQ8bZ1tW3KI0Ztn2epk.jpg"
            )
        )

        listTvShow.add (
            TvShowModel(
                id = 12,
                name = "The Good Doctor",
                overview = "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives?",
                poster = "https://image.tmdb.org/t/p/original/bi4tb3GMYFVNUom65SJm7A66rgM.jpg",
                release = "Sep 25, 2017",
                imgBackground = "https://image.tmdb.org/t/p/original/uLLN44G7CR2zbQ5c90iZt0uVjZZ.jpg"
            )
        )

        listTvShow.add (
            TvShowModel(
                id = 13,
                name = "Euphoria",
                overview = "A group of high school students navigate love and friendships in a world of drugs, sex, trauma, and social media.",
                poster = "https://image.tmdb.org/t/p/original/hDPKpdfXmnkgyCZw5Qj1RMIWDnv.jpg",
                release = "Jun 16, 2019",
                imgBackground = "https://image.tmdb.org/t/p/original/9KnIzPCv9XpWA0MqmwiKBZvV1Sj.jpg"
            )
        )

        listTvShow.add (
            TvShowModel(
                id= 14,
                name = "S.W.A.T",
                overview = "A locally born and bred S.W.A.T. lieutenant is torn between loyalty to the streets and duty to his fellow officers when he's tasked to run a highly-trained unit that's the last stop for solving crimes in Los Angeles.",
                poster = "https://image.tmdb.org/t/p/original/am7NOjx56BpJOh1yFy6P70WmuTb.jpg",
                release = "Nov 2, 2017",
                imgBackground = "https://image.tmdb.org/t/p/original/AuY5Wuiwgc2CeuzM0I2poSe4E0x.jpg"
            )
        )

        listTvShow.add (
            TvShowModel(
                id = 15,
                name = "FBI",
                overview = "The New York office of the FBI brings to bear all their talents, intellect and technical expertise on major cases in order to keep their city and the country safe.",
                poster = "https://image.tmdb.org/t/p/original/j39IIKLYWsGzMepFE1xFBFbFsd3.jpg",
                release = "Sep 25, 2018",
                imgBackground = "https://image.tmdb.org/t/p/original/uoBXmXoN1iDFbN0zFUtV5QLSqJ2.jpg"
            )
        )

        listTvShow.add (
            TvShowModel(
                id = 16,
                name = "The Boys",
                overview = "Sekelompok penjaga yang dikenal secara informal sebagai \"The Boys\" berangkat untuk menjatuhkan superhero yang korup dengan tidak lebih dari grit kerah biru dan kesediaan untuk melawan yang kotor.",
                poster = "https://image.tmdb.org/t/p/original/dzOxNbbz1liFzHU1IPvdgUR647b.jpg",
                release = "Jul 25, 2019",
                imgBackground = "https://image.tmdb.org/t/p/original/czffzEgaBko4mXW84B1J1EnQBzo.jpg"
            )
        )

        listTvShow.add (
            TvShowModel(
                id = 17,
                name = "A Teacher",
                overview = "A Teacher explores the complexities and consequences of a predatory relationship between a female teacher, Claire and her male high school student, Eric. Starting with the simple act of tutoring, boundaries are crossed, and a subtle game of grooming begins, leaving permanent damage that is impossible to ignore.",
                poster = "https://image.tmdb.org/t/p/original/q7TnBWitPlR33rCxZwKrA9jYrWP.jpg",
                release = "Nov 10, 2020",
                imgBackground = "https://image.tmdb.org/t/p/original/wHcurqKFGAM9dA0zfqhpEXXSe6Q.jpg"
            )
        )

        listTvShow.add (
            TvShowModel(
                id = 18,
                name = "Next",
                overview = "A Silicon Valley pioneer discovers that one of his own creations – a powerful A.I. – might spell global catastrophe, and teams up with a cybercrime agent to fight a villain unlike anything we’ve ever seen – one whose greatest weapon against us is ourselves.",
                poster = "https://image.tmdb.org/t/p/original/c3UtJSsYGCRKsIlBZOA9JbOKHNa.jpg",
                release = "Oct 6, 2020",
                imgBackground = "https://image.tmdb.org/t/p/original/jLAwSnlxpO6gCdjZR3c5Uenvvir.jpg"
            )
        )

        listTvShow.add (
            TvShowModel(
                id = 19,
                name = "Station 19",
                overview = "A group of heroic firefighters at Seattle Fire Station 19—from captain to newest recruit—risk their lives and hearts both in the line of duty and off the clock. These brave men and women are like family, literally and figuratively, and together they put their own lives in jeopardy as first responders to save the lives of others.",
                poster = "https://image.tmdb.org/t/p/original/p2TTrz0KZUdsKUJxfTrxeXNOG9l.jpg",
                release = "Mar 22, 2018",
                imgBackground = "https://image.tmdb.org/t/p/original/7Cvv4KdtI00xNti4Dm4RVJDL9qU.jpg"
            )
        )

        listTvShow.add (
            TvShowModel(
                id = 20,
                name = "SEAL Team",
                overview = "The lives of the elite Navy Seals as they train, plan and execute the most dangerous, high-stakes missions our country can ask.",
                poster = "https://image.tmdb.org/t/p/original/suz4ND6bIJaJ2i832or8eYfzQGM.jpg",
                release = "Sep 27, 2017",
                imgBackground = "https://image.tmdb.org/t/p/original/6lOtF3yx8iurvaBVz1ZVhwcRgmD.jpg"
            )
        )
        return listTvShow
    }
}