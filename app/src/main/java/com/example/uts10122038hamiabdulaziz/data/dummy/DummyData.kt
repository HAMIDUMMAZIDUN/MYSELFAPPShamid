package com.example.uts10122038hamidabdulaziz.data.dummy

import com.example.uts10122038hamidabdulaziz.R
import com.example.uts10122038hamidabdulaziz.data.model.DailyActivityData
import com.example.uts10122038hamidabdulaziz.data.model.FriendData
import com.example.uts10122038hamidabdulaziz.data.model.InterestData
import com.example.uts10122038hamidabdulaziz.data.model.ProfileData
import com.example.uts10122038hamidabdulaziz.data.model.GalleryItem
import com.example.uts10122038hamidabdulaziz.data.model.MusicData
import com.example.uts10122038hamidabdulaziz.data.model.VideoData
import com.example.uts10122038hamidabdulaziz.data.model.ProfileInfoData

object DummyData {

    fun getProfileData(): ProfileData {
        return ProfileData(
            photo = R.drawable.hamid,
            name = "HAMID ABDUL AZIZ",
            description = "Hai! Saya adalah mahasiswa Teknik Informatika yang memiliki ketertarikan dalam pengembangan web, khususnya di bidang UI/UX. Saya menikmati proses merancang dan membangun antarmuka yang intuitif, menarik, dan mudah digunakan. Di luar aktivitas ngoding, saya juga suka bermain game dan mendengarkan musik. Ke depannya, saya ingin menjadi seorang web developer profesional yang fokus pada pengalaman pengguna dan desain yang fungsional"
        )
    }

    fun getInterestData(): List<InterestData> {
        return listOf(
            InterestData(
                title = "Hobi",
                items = listOf(
                    "mencari yang belum tau",
                    "Mendengarkan musik",
                    "bermain game"
                )
            ),
            InterestData(
                title = "Makes (Yang Disukai)",
                items = listOf(
                    "Film Action",
                    "Makanan manis",
                    "thai tea"
                )
            ),
            InterestData(
                title = "Mikes (Yang Tidak Disukai)",
                items = listOf(
                    "Tempat Sepi",
                    "Makanan Aneh"
                )
            ),
            InterestData(
                title = "Interest (Minat)",
                items = listOf(
                    "UI/UX Design",
                    "Web Development",
                    "Desainer Grafis"
                )
            ),
            InterestData(
                title = "Cita-cita",
                items = listOf(
                    "Menjadi Web Developer profesional",
                    "Membuat Tamppilan yang enak dipandang",
                    "Bekerja di perusahaan teknologi besar",
                    "punya usaha sendiri",
                    "Menaik hajikan satu kampung"
                )
            )
        )
    }
    fun getDailyActivities(): List<DailyActivityData> {
        return listOf(
            DailyActivityData(
                id = 1,
                title = "Kuliah Keamanan Big Data",
                description = "Mengikuti perkuliahan Keamanan Big Data bersama Irawan Afrianto",
                time = "07:00 - 09:30",
                image = R.drawable.ic_daily_activity_1
            ),
            DailyActivityData(
                id = 2,
                title = "Kuliah Rekayasa Fitur",
                description = "Perkuliahan Rekayasa Fitur dengan Galih Hermawan",
                time = "07:00 - 09:30",
                image = R.drawable.ic_daily_activity_2
            ),
            DailyActivityData(
                id = 3,
                title = "Kuliah Manajemen Proyek Perangkat Lunak",
                description = "Belajar manajemen proyek bersama Prof. Herman S. Soegoto",
                time = "13:40 - 16:10",
                image = R.drawable.ic_daily_activity_3
            ),
            DailyActivityData(
                id = 4,
                title = "Kuliah Pemrograman Android",
                description = "Mengikuti perkuliahan Pemrograman Android di Lab-5",
                time = "07:00 - 11:10",
                image = R.drawable.ic_daily_activity_4
            ),
            DailyActivityData(
                id = 5,
                title = "Kuliah Kualitas & Pengujian Perangkat Lunak",
                description = "Materi pengujian perangkat lunak bersama Alif Finandhita",
                time = "13:40 - 16:10",
                image = R.drawable.ic_daily_activity_5
            )
        )
    }

    fun getFriends(): List<FriendData> {
        return listOf(
            FriendData(
                id = 1,
                name = "Nadia",
                image = R.drawable.ic_friend_1
            ),
            FriendData(
                id = 2,
                name = "Farhan",
                image = R.drawable.ic_friend_2
            ),
            FriendData(
                id = 3,
                name = "Lia",
                image = R.drawable.ic_friend_3
            ),
            FriendData(
                id = 4,
                name = "Raka",
                image = R.drawable.ic_friend_4
            ),
            FriendData(
                id = 5,
                name = "Sinta",
                image = R.drawable.ic_friend_5
            ),
            FriendData(
                id = 6,
                name = "Bagas",
                image = R.drawable.ic_friend_6
            )
        )
    }
    fun getGalleryItems(): List<GalleryItem> {
        return listOf(
            GalleryItem(
                id = 1,
                imageRes = R.drawable.gallery_image_1,
                title = "Holiday"
            ),
            GalleryItem(
                id = 2,
                imageRes = R.drawable.gallery_image_2,
                title = "Makan"
            ),
            GalleryItem(
                id = 3,
                imageRes = R.drawable.gallery_image_3,
                title = "Saya Waktu Kecil"
            ),
            GalleryItem(
                id = 4,
                imageRes = R.drawable.gallery_image_4,
                title = "Makanan"
            ),
            GalleryItem(
                id = 5,
                imageRes = R.drawable.gallery_image_5,
                title = "Makanan"
            ),
            GalleryItem(
                id = 6,
                imageRes = R.drawable.gallery_image_6,
                title = "Makanan"
            ),
            GalleryItem(
                id = 7,
                imageRes = R.drawable.gallery_image_7,
                title = "Makanan"
            ),
            GalleryItem(
                id = 8,
                imageRes = R.drawable.gallery_image_8,
                title = "Makanan"
            ),
            GalleryItem(
                id = 9,
                imageRes = R.drawable.gallery_image_9,
                title = "Makanan"
            ),
            GalleryItem(
                id = 10,
                imageRes = R.drawable.gallery_image_10,
                title = "Makanan"
            ),
            GalleryItem(
                id = 11,
                imageRes = R.drawable.gallery_image_11,
                title = "Makanan"
            )
        )
    }

    fun getFavoriteMusic(): List<MusicData> {
        return listOf(
            MusicData(
                id = 1,
                title = "Golden Hour",
                artist = "JVKE",
                albumCover = R.drawable.album_cover_1,
                duration = "3:29"
            ),
            MusicData(
                id = 2,
                title = "As It Was",
                artist = "Harry Styles",
                albumCover = R.drawable.album_cover_2,
                duration = "2:47"
            ),
            MusicData(
                id = 3,
                title = "Easy On Me",
                artist = "Adele",
                albumCover = R.drawable.album_cover_3,
                duration = "3:45"
            ),
            MusicData(
                id = 4,
                title = "Shivers",
                artist = "Ed Sheeran",
                albumCover = R.drawable.album_cover_4,
                duration = "3:27"
            ),
            MusicData(
                id = 5,
                title = "Stay",
                artist = "The Kid LAROI & Justin Bieber",
                albumCover = R.drawable.album_cover_5,
                duration = "2:21"
            ),
            MusicData(
                id = 6,
                title = "Ghost",
                artist = "Justin Bieber",
                albumCover = R.drawable.album_cover_6,
                duration = "2:33"
            ),
            MusicData(
                id = 7,
                title = "Anti-Hero",
                artist = "Taylor Swift",
                albumCover = R.drawable.album_cover_7,
                duration = "3:20"
            ),
            MusicData(
                id = 8,
                title = "Blinding Lights",
                artist = "The Weeknd",
                albumCover = R.drawable.album_cover_8,
                duration = "3:20"
            )
        )

    }

    fun getFavoriteVideos(): List<VideoData> {
        return listOf(
            VideoData(
                id = 1,
                title = "Mastering Android Studio for Beginners",
                channel = "CodeTuts",
                thumbnail = R.drawable.video_thumbnail_1,
                duration = "11:10",
                views = "1.1M views"
            ),
            VideoData(
                id = 2,
                title = "Top 7 Kotlin Features You Should Know",
                channel = "DevSimplify",
                thumbnail = R.drawable.video_thumbnail_2,
                duration = "9:05",
                views = "910K views"
            ),
            VideoData(
                id = 3,
                title = "Modern UI Design with Jetpack Compose",
                channel = "UXCraft",
                thumbnail = R.drawable.video_thumbnail_3,
                duration = "16:00",
                views = "492K views"
            ),
            VideoData(
                id = 4,
                title = "Clean Code Practices in Android",
                channel = "BuildWithCode",
                thumbnail = R.drawable.video_thumbnail_4,
                duration = "13:45",
                views = "370K views"
            ),
            VideoData(
                id = 5,
                title = "Understanding LiveData and ViewModel",
                channel = "DevNerds",
                thumbnail = R.drawable.video_thumbnail_5,
                duration = "17:30",
                views = "820K views"
            ),
            VideoData(
                id = 6,
                title = "List Adapter vs RecyclerView Adapter",
                channel = "LearnAndroid",
                thumbnail = R.drawable.video_thumbnail_6,
                duration = "12:58",
                views = "608K views"
            )
        )
    }
    fun getProfileInfo(): ProfileInfoData {
        return ProfileInfoData(
            photo = R.drawable.hamid,
            name = "HAMID ABDUL AZIZ",
            description = "Mahasiswa Teknik Informatika yang sedang fokus belajar pengembangan aplikasi Android. Menyukai UI/UX design dan pemrograman mobile. Bercita-cita menjadi developer profesional yang membuat aplikasi bermanfaat bagi banyak orang.",
            phone = "081214019947",
            email = "hamidabdulaziz36@gmail.com",
            instagram = "@hamidabdulaziz",
            latitude = -6.886693,  // Contoh koordinat (sesuaikan dengan lokasi yang diinginkan)
            longitude = 107.615173, // Contoh koordinat Bandung
            address = "Bandung, Jawa Barat, Indonesia"
        )
    }

    fun getAppVersion(): String {
        return "1.0.0"
    }

    fun getAppInfo(): String {
        return "Myself Apps adalah aplikasi yang dibuat sebagai tugas UTS Pemrograman Mobile. Aplikasi ini menampilkan informasi tentang diri saya, aktivitas harian, galeri, musik dan video favorit, serta profil lengkap. Dibuat dengan penuh semangat dan kerja keras menggunakan Android Studio dan bahasa pemrograman Kotlin."
    }


}