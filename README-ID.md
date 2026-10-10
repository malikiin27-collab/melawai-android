# Aplikasi Pegawai Melawai Android — 1.0.0

Status: proyek kode sumber. BELUM dikompilasi menjadi APK dan BELUM diuji pada perangkat. Lingkungan pembuat paket tidak memiliki Android SDK/Gradle. Jangan menyebut paket ini APK siap pasang.

Alamat website: https://datawebs.my.id/melawai
ID aplikasi: id.melawai.pegawai
Minimum Android 8.0. JDK 17, Android SDK Platform 35, Gradle 8.9, Android Gradle Plugin 8.7.3.

## Isi dan penggunaan
1. Unggah Website-Patch/melawai/assets/native-sync.js ke website, timpa file yang sama. Muat ulang tanpa cache; pastikan service worker tidak menyajikan versi JS lama.
2. Buka folder Android di Android Studio. Pasang SDK 35 dan Gradle 8.9.
3. Jika Gradle wrapper belum tersedia, jalankan `gradle wrapper --gradle-version 8.9` menggunakan instalasi Gradle 8.9. Lalu jalankan `./gradlew assembleDebug` (Windows: gradlew.bat assembleDebug).
4. APK uji berada di app/build/outputs/apk/debug/app-debug.apk. APK debug hanya untuk pengujian internal.
5. Untuk distribusi resmi: Android Studio > Generate Signed App Bundle or APK > APK. Buat keystore organisasi dan simpan dengan aman. Gunakan kunci yang sama untuk semua pembaruan. Jangan menaruh keystore/password di website atau ZIP sumber.
6. APK release yang sudah ditandatangani dan diuji dapat diunggah ke menu unduhan aplikasi pada website. Paket ini belum menambahkan tautan APK karena binernya belum ada.

## Alur GPS
Login menggunakan layar website. Sesi web ditukar dengan token API pegawai melalui bridge.php yang sudah ada dalam ZIP website. Token disimpan terenkripsi dengan Android Keystore. Akun admin tidak mendapat token pegawai.
Mulai Bertugas dilakukan pada halaman Jam Kerja & Lokasi website. Ketika website mengirim status aktif, aplikasi meminta izin lokasi akurat dan notifikasi, lalu menjalankan foreground service lokasi. Notifikasi tetap terlihat.
Layanan memeriksa status server setiap sekitar 30 detik, mengirim titik GPS baru jika sesi masih aktif. Selesai Bertugas menghentikan layanan; layanan juga berhenti ketika status server tidak aktif. Penutupan sesi server bisa memerlukan siklus pemeriksaan berikutnya jika dilakukan dari perangkat lain.
Layar terkunci/minimize didukung oleh rancangan layanan. Force Stop, HP mati, GPS mati, izin dicabut atau pembatasan baterai pabrikan dapat menghentikan/membatasi pelacakan. Tidak ada mekanisme untuk melewati Force Stop. Setelah reboot, buka aplikasi kembali. Tidak menjanjikan tracking 24 jam atau pelacakan tanpa sepengetahuan pegawai.
Tidak ada antrean riwayat offline pada versi ini: notifikasi menunjukkan koneksi terputus; lokasi terbaru dilanjutkan saat koneksi tersedia, titik saat offline tidak direkonstruksi.
Saat logout, layanan dihentikan dan token lokal dihapus. Token server mengikuti masa berlaku/revokasi API website yang sudah ada.

## Fitur lain
Layar login, laporan, cuti dan profil mengikuti website secara realtime. Input file menggunakan pemilih file Android; kamera web membutuhkan izin kamera. Unduhan HTTPS pada domain Melawai memakai DownloadManager dan cookie login. Tautan luar dibuka pada aplikasi/browser eksternal. Sertifikat TLS tidak diabaikan.
Internet diperlukan. Tidak menyalin PHP, database, foto pribadi atau password database ke dalam APK.

## Pemeriksaan sebelum distribusi
Uji akun PJLP dan PPPK secara terpisah: login, logout/ganti akun, Mulai Bertugas, Selesai Bertugas, izin ditolak/dicabut, layar terkunci 15 menit, swipe aplikasi dari recent apps, Force Stop, offline-online, GPS mati, dan token kedaluwarsa. Bandingkan waktu lokasi terakhir di dashboard admin.
Uji kamera/upload foto dan unduh PDF pada Android 8, 13 dan 14/15, serta ponsel yang memiliki penghemat baterai agresif. Jika izin lokasi diberikan dari dialog pertama, reload halaman Jam Kerja sebelum mengulang Mulai Bertugas bila browser belum mendapatkan izin.
Periksa native-sync.js terbaru benar-benar dimuat dan Android System WebView mendukung WEB_MESSAGE_LISTENER.

## Referensi
https://developer.android.com/develop/background-work/services/fgs/service-types
https://developer.android.com/develop/background-work/services/fgs/handle-user-stopping
https://developer.android.com/reference/androidx/webkit/WebViewCompat
