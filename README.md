# Aplikasi Administrasi Melawai — Android V10

Aplikasi ini membuka **https://melawai.datawebs.my.id/**. Pegawai (PJLP/PPPK) dan administrator masuk melalui login yang sama; **otorisasi dan penentuan halaman hanya dilakukan server**, bukan pada perangkat.

## Fitur
- Login web sesuai peran dan sesi masing-masing
- Administrasi pegawai dan admin berdasarkan izin di website
- Pilihan Kamera / Galeri saat unggah foto dari formulir website
- Pelacakan lokasi ketika sesi kerja aktif dan pengguna memberikan izin (foreground service)
- Navigasi HTTPS terbatas ke domain kelurahan; tautan eksternal dibuka di browser
- APK debug otomatis melalui GitHub Actions

## Bangun APK uji
1. Buat repositori GitHub kosong (lebih baik **Private**) lalu upload **isi ZIP**, bukan file ZIP saja.
2. Pastikan branch utama `main`. Buka tab Actions → APK Uji Melawai → Run workflow.
3. Unduh artifact `Melawai-APK-Uji-V10` dan ambil `app-debug.apk`.
4. APK adalah **debug**, bukan APK rilis Play Store. Android 8.0+ diperlukan.

## Catatan operasional dan privasi
- Memerlukan akses internet dan situs HTTPS yang berfungsi. Jika server atau database bermasalah, aplikasi tidak memperbaikinya.
- Pelacakan GPS membutuhkan izin lokasi akurat, notifikasi sesuai versi Android, dan sesi aktif. Android dapat membatasi pelacakan oleh pengaturan baterai/perangkat; tidak dijamin setelah Force Stop.
- Admin hanya memiliki fitur yang sudah tersedia dan diizinkan di website. Jangan menganggap APK ini meningkatkan hak akses admin.
- Belum diverifikasi melalui build GitHub Actions maupun pengujian di perangkat nyata.
