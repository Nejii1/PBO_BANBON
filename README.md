

# Aplikasi Inventory Gudang Ban

**Deskripsi Singkat:**
Aplikasi Inventory Gudang Ban adalah sebuah sistem yang dibangun menggunakan NetBeans dan Java untuk membantu mengelola inventaris ban di sebuah gudang. Aplikasi ini dirancang untuk memudahkan tracking stok ban, mengelola data pemasok, dan memantau pengeluaran serta penerimaan barang secara efisien.

**Fitur Utama:**
- **Manajemen Stok:** Melacak jumlah ban yang tersedia di gudang secara real-time.
- **Pencatatan Penerimaan:** Mencatat dan mengelola penerimaan ban dari pemasok.
- **Pencatatan Pengeluaran:** Mengelola pengeluaran ban untuk distribusi atau penjualan.
- **Manajemen Pemasok:** Menyimpan dan mengelola data pemasok ban.
- **Laporan Stok:** Membuat laporan stok secara berkala untuk memantau persediaan.
- **Notifikasi Stok Rendah:** Memberikan notifikasi ketika stok ban mendekati batas minimum.

**Teknologi yang Digunakan:**
- **Bahasa Pemrograman:** Java
- **IDE:** NetBeans
- **Database:** MySQL (atau dapat disesuaikan sesuai kebutuhan)
- **Framework:** JavaFX untuk antarmuka pengguna

**Persyaratan Sistem:**
- **JDK:** Java Development Kit (JDK) versi 8 atau lebih baru
- **IDE:** NetBeans IDE versi terbaru
- **Database Server:** MySQL versi 5.7 atau lebih baru
- **Sistem Operasi:** Windows, macOS, atau Linux

**Panduan Instalasi:**
1. **Clone Repository:**
   ```bash
   git clone [https://github.com/nurkholiswakhid/STOKBAN.git]
   ```
2. **Import Project ke NetBeans:**
   - Buka NetBeans.
   - Pilih `File > Open Project`.
   - Arahkan ke folder hasil clone repository dan buka.
3. **Konfigurasi Database:**
   - Buat database baru di MySQL dengan nama `STOKBAN`.
   - Import skema database dari file `BAN.sql` yang terdapat di dalam folder `SQL`.
   - Sesuaikan konfigurasi koneksi database di file `src/stokban/Koneksi.java`.
4. **Jalankan Aplikasi:**
   - Pilih proyek di NetBeans.
   - Klik kanan dan pilih `Run`.

**Penggunaan:**
1. **Login:**
   - Masukkan username dan password yang telah terdaftar.
2. **Dashboard:**
   - Melihat ringkasan stok ban dan aktivitas terakhir.
3. **Manajemen Stok:**
   - Menambah, mengurangi, dan memperbarui data stok ban.
4. **Laporan:**
   - Generate laporan stok dan transaksi.

**Kontribusi:**
Kami menyambut kontribusi dari siapa pun. Jika Anda memiliki ide atau menemukan bug, silakan buka issue atau pull request.

**Lisensi:**
Aplikasi ini dilisensikan di bawah MIT License. Untuk detail lebih lanjut, lihat file `LICENSE` di repository ini.

---


