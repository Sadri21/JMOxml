package com.app.myapplication.listResource


import com.app.myapplication.R

object ListResource {
    val layananListDashboard = listOf(
        LayananItem(
            layananName = "Jaminan Hari Tua",
            layananDescription = "Anda sudah terdaftar di layanan ini",
            layananImage = R.drawable.jht
        ),
        LayananItem(
            layananName = "Jaminan Kecelakaan Kerja",
            layananDescription = "Anda sudah terdaftar di layanan ini",
            layananImage = R.drawable.jkk
        )
    )

    val listBannerSrc = listOf(R.drawable.banner, R.drawable.banner2)

    val layananListMenu = listOf(
        LayananItem(
            layananName = "Jaminan Hari Tua",
            layananDescription = "Anda sudah terdaftar di layanan ini",
            layananImage = R.drawable.jht
        ),
        LayananItem(
            layananName = "Jaminan Kecelakaan Kerja",
            layananDescription = "Anda sudah terdaftar di layanan ini",
            layananImage = R.drawable.jkk
        ),
        LayananItem(
            layananName = "Jaminan Kematian",
            layananDescription = "Anda sudah terdaftar di layanan ini",
            layananImage = R.drawable.jk
        ),
        LayananItem(
            layananName = "Jaminan Pensiun",
            layananDescription = "Anda sudah terdaftar di layanan ini",
            layananImage = R.drawable.jp
        ),
        LayananItem(
            layananName = "Jaminan Kehilangan Pekerjaan",
            layananDescription = "Anda sudah terdaftar di layanan ini",
            layananImage = R.drawable.jp
        )


    )

    val menuDashboard = listOf(
        MenuItem(
            menuName = "Info Program",
            menuImage = R.drawable.round_card_membership_black_36
        ),
        MenuItem(
            menuName = "Bayar/AutoDebit",
            menuImage = R.drawable.round_payments_black_36
        ),
        MenuItem(
            menuName = "Daftar BPU",
            menuImage =  R.drawable.round_manage_accounts_black_36
        ),
        MenuItem(
            menuName = "Pengkinian Data",
            menuImage =  R.drawable.round_restore_page_black_36
        ),
        MenuItem(
            menuName = "Kantor Cabang",
            menuImage =  R.drawable.round_apartment_black_36
        ),
        MenuItem(
            menuName = "Mitra Layanan",
            menuImage =  R.drawable.round_maps_home_work_black_36
        ),
        MenuItem(
            menuName = "Pengaduan",
            menuImage =  R.drawable.round_drafts_black_36
        ),
        MenuItem(
            menuName = "Bantuan",
            menuImage =  R.drawable.round_headset_mic_black_36
        ),
        MenuItem(
            menuName = "Menu Lainnya",
            menuImage =  R.drawable.round_more_horiz_black_36
        )
    )
}